/** @format */
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { useState } from "react";
const AddProduct = ({ onAdd }) => {
  const [code, setCode] = useState("");
  const [name, setName] = useState("");
  const [price, setPrice] = useState(0);

  const onSubmit = (e) => {
    e.preventDefault();
    let image = "";

    if (!code) {
      alert("pls add a code");
      return;
    }
    onAdd({ code, image, name, price });
    setCode("");
    setName("");
    setPrice(0);
  };

  return (
    <Form onSubmit={onSubmit}>
      <Form.Group className='mb-3' controlId='formCode'>
        <Form.Label>Code</Form.Label>
        <Form.Control
          placeholder='Code'
          value={code}
          onChange={(e) => setCode(e.target.value)}
        />
      </Form.Group>
      <Form.Group controlId='formFile' className='mb-3'>
        <Form.Label>Image</Form.Label>
        <Form.Control type='file' />
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
      {/* <Form.Group controlId='formGridState'>
        <Form.Label>Date</Form.Label>
        <Form.Control value={date} onChange={(e) => setDate(e.target.value)} />
      </Form.Group> */}
      <Button variant='primary' type='submit'>
        Submit
      </Button>{" "}
    </Form>
  );
};

export default AddProduct;
