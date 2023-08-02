/** @format */
import { useState, useEffect } from "react";
import ProductCard from "./Product";
import Button from "react-bootstrap/Button";
import AddProduct from "./AddProduct";
import EditProduct from "./EditProduct";

//import { useLocation } from "react-router-dom";
const Products = () => {
  const [showAddProdut, setShowAddProdut] = useState(false);
  const [showEditProdut, setShowEditProdut] = useState(false);
  const [products, setProducts] = useState([]);
  //const location = useLocation();

  useEffect(() => {
    const getProducts = async () => {
      const productsFormServer = await fetchProducts();
      setProducts(productsFormServer);
    };
    getProducts();
  }, []);

  const fetchProducts = async () => {
    const res = await fetch("http://localhost:8080/products");
    const data = await res.json();
    return data;
  };

  const addProduct = async (product) => {
    const res = await fetch("http://localhost:8080/products", {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify(product),
    });

    const data = await res.json();
    setProducts([...products, data]);
  };

  //delete producrt
  const deleteProduct = async (code) => {
    await fetch(`http://localhost:8080/products/${code}`, {
      method: "DELETE",
    });
    setProducts(products.filter((product) => product.code !== code));
  };

  const editProduct = async (updateProduct) => {
    setShowEditProdut(!showEditProdut);

    console.log(updateProduct);

    const res = await fetch("http://localhost:8080/products", {
      method: "PUT",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify(updateProduct),
    });

    const data = await res.json();
    console.log(data);
    setProducts(
      products.map((product) =>
        product.code === updateProduct.code
          ? [...products, updateProduct]
          : product
      )
    );
    setShowEditProdut(!showEditProdut);
  };

  return (
    <div className='container'>
      <div className='section-title'>
        <h2>Product List</h2>
        <Button
          style={{ float: "right", fontSize: "15px" }}
          variant={!showAddProdut ? "primary" : "danger"}
          onClick={() => setShowAddProdut(!showAddProdut)}>
          {!showAddProdut ? "Add Product" : "Close"}
        </Button>
      </div>
      <> {showAddProdut ? <AddProduct onAdd={addProduct} /> : ""}</>
      {/* <div>
        <> {showEditProdut ? <EditProduct /> : ""}</>
      </div> */}
      {products.map((product) => (
        <div key={product.code}>
          <ProductCard
            product={product}
            onEdit={() => setShowEditProdut(!showEditProdut)}
            onDelete={deleteProduct}
          />
          <div>
            {" "}
            {showEditProdut ? (
              <EditProduct
                codeEdit={product.code}
                nameEdit={product.name}
                priceEdit={product.price}
                onProductEdit={editProduct}
              />
            ) : (
              ""
            )}
          </div>
        </div>
      ))}
    </div>
  );
};

export default Products;
