/** @format */
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
//,padding:"10px 10px 10px 10px"

const ProductCard = ({ product, onDelete, onEdit }) => {
  return (
    <Card
      style={{
        width: "25rem",
        display: "inline-block",
        margin: "15px 15px 15px 15px",
      }}>
      <Card.Img variant='top' src='img/burger-01.jpg' />
      <Card.Body>
        <Card.Title>
          <b>Code :</b> {product.code}
        </Card.Title>
        <Card.Title>
          <b>Name :</b>
          {product.name}
        </Card.Title>
        <Card.Title>
          <b>Price :</b>Rs {product.price}
        </Card.Title>
        <p>{product.createDate}</p>
        <Button variant='info' onClick={onEdit}>
          Edit
        </Button>{" "}
        <Button variant='danger' onClick={() => onDelete(product.code)}>
          Delete
        </Button>
      </Card.Body>
    </Card>
  );
};

export default ProductCard;
