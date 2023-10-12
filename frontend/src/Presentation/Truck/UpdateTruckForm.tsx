import { TruckRepositoryImpl } from "../../Data/Repositories/TruckRepositoryImpl";
import { useNotification } from "../../Services/useNotification";
import { TruckDataSourceImpl } from "../../Data/DataSources/Truck/TruckAPIDataSource";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Form, Button } from 'react-bootstrap';

export function UpdateTruckForm() {
  const notify = useNotification();
  const [latitude, setLatitude] = useState<any>();
  const [longitude, setLongitude] = useState<any>();
  const [status, setStatus] = useState<any>("HEALTHY");
  const { id } = useParams();
  const navigate = useNavigate();

  const truckRepo = new TruckRepositoryImpl(new TruckDataSourceImpl());

  const getMyLocation = () => {
    const location = window.navigator && window.navigator.geolocation

    if (location) {
      location.getCurrentPosition((position) => {
        setLatitude(position.coords.latitude);
        setLongitude(position.coords.longitude);
      }, (error) => {
        console.error(error)
      })
    }

  }

  useEffect(() => {
    getMyLocation();
  })

  const handleUpdate = async (e: { preventDefault: () => void; }) => {

    e.preventDefault();

    if (!latitude || !longitude || !status) {
      notify.error("Please fill all fields.");
      return;
    }

    const baseData = { latitude, longitude, status };

    if (id) {
      await truckRepo.updateTruck(baseData, id);
      notify.success("Updated Successfully");
      navigate('/')
    }

  };



  return (
    <fieldset>
      <legend>Update Truck</legend>
      <div className="container">
        <Form onSubmit={handleUpdate}>
          <Form.Group className="mb-3" controlId="latitude" >
            <Form.Label>Latitude</Form.Label>
            <Form.Control value={latitude} onChange={e => setLatitude(e.target.value)} type="text" placeholder="latitude" />
          </Form.Group>
          <Form.Group className="mb-3" controlId="longitude">
            <Form.Label>Longitude</Form.Label>
            <Form.Control value={longitude} onChange={e => setLongitude(e.target.value)} placeholder="longitude" type="text" />
          </Form.Group>
          <Form.Group className="mb-3" controlId="status">
            <Form.Label>Status</Form.Label>
            <Form.Select value={status} onChange={e => setStatus(e.target.value)}>
              <option value="HEALTHY">HEALTHY</option>
              <option value="UNHEALTHY">UNHEALTHY</option>
            </Form.Select>
          </Form.Group>
          <Button type="submit">Update</Button>
        </Form>
      </div>

    </fieldset>
  );
}
