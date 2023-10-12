import { TruckRepositoryImpl } from "../../Data/Repositories/TruckRepositoryImpl";
import { TruckDataSourceImpl } from "../../Data/DataSources/Truck/TruckAPIDataSource";
import { Card, Button } from "react-bootstrap";
import Paginate from "../UI/Components/Paginate";
import { Truck } from "../../Domain/Models/Truck";
import { useEffect, useState } from "react";
import { TrucksResponseDTO } from "../../Data/DTOs/TrucksResponseDTO";
import { useNavigate } from 'react-router-dom';


export function TruckList() {
  const [currentPage, setCurrentPage] = useState(0);
  const [status, setStatus] = useState("all");
  const [postsPerPage] = useState(3);
  const [data, setData] = useState<TrucksResponseDTO>();
  const navigate = useNavigate();

  const truckRepo = new TruckRepositoryImpl(new TruckDataSourceImpl());

  const getData = async () => {
    const data = await truckRepo.getTrucks(currentPage, status);
    setData(data);
  }


  const previousPage = () => {
    if (currentPage !== 0) {
      setCurrentPage(currentPage - 1);
    }
  };

  const nextPage = () => {
    if (currentPage !== Math.ceil(data?.totalItems! / postsPerPage)) {
      setCurrentPage(currentPage + 1);
    }
  };

  useEffect(() => {
    getData();
  }, [currentPage, status])

  return (
    <fieldset>
      <>
        <div className="container">
          <p>Filter Trucks</p>
          <select onChange={e => setStatus(e.target.value)} >
            <option value="all">ALL</option>
            <option value="HEALTHY">HEALTHY</option>
            <option value="UNHEALTHY">UNHEALTHY</option>
          </select>
        </div>

        {data?.items?.length === 0 ? (
          <div>No available trucks.</div>
        ) : (
          <div className="container">
            <div className="row">


              {data?.items.map((truck: Truck) => (
                <div className="col-lg-4" key={truck.id}>
                  <Card>
                    <Card.Img variant="top" src={truck.photoUrl} />
                    <Card.Body>
                      <Card.Title>{truck.truckName}</Card.Title>
                      <Card.Text>
                        <div>
                        <p><b>Latitude:</b> {truck.latitude}</p>
                        </div>
                        <div>
                        <p><b>Longitude:</b> {truck.longitude}</p>
                        </div>
                        <div>
                        <p><b>Status:</b> {truck.status}</p>
                        </div>
                      </Card.Text>
                      <Button onClick={() => navigate(`/trucks/${truck.id}`)} variant="primary">Update Location</Button>
                    </Card.Body>
                  </Card>
                </div>

              ))}

              <Paginate
                currentPage={data?.currentPage!}
                totalPages={data?.totalPages!}
                nextPage={nextPage}
                previousPage={previousPage}
              />

            </div>
          </div>


        )}
      </>

    </fieldset>
  );
}
