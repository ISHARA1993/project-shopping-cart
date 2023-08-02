/** @format */
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { useState } from "react";
const EditProduct = ({ codeEdit, nameEdit, priceEdit, onProductEdit }) => {
  const [code, setCode] = useState(codeEdit);
  const [name, setName] = useState(nameEdit);
  const [price, setPrice] = useState(priceEdit);

  const onSubmit = (e) => {
    e.preventDefault();
    let image = "";

    onProductEdit({ code, image, name, price });
    setCode("");
    setName("");
    setPrice(0);
    window.location.reload(true);
  };

  return (
    <Form onSubmit={onSubmit} className='container'>
      <Form.Group className='mb-3' controlId='formCode'>
        <Form.Label>Code</Form.Label>
        <Form.Control
          placeholder='Code'
          value={code}
          onChange={(e) => setCode(e.target.value)}
        />
      </Form.Group>
      <Form.Group className='mb-3' controlId='formName'>
        <Form.Label>Name</Form.Label>
        <Form.Control
          placeholder='Name'
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
      </Form.Group>
      <Form.Group controlId='formPrice'>
        <Form.Label>Price</Form.Label>
        <Form.Control
          value={price}
          onChange={(e) => setPrice(e.target.value)}
        />
      </Form.Group>
      <Button variant='primary' type='submit'>
        Submit
      </Button>
    </Form>
  );
};

export default EditProduct;
