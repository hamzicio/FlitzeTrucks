import { TruckDataSource } from "./TruckDataSource";
import { Truck, UpdateTruckDTO } from "../../../Domain/Models/Truck";
import { Http } from "../../../Services/Http";
import { TrucksResponseDTO } from "../../DTOs/TrucksResponseDTO";

export class TruckDataSourceImpl implements TruckDataSource {
  async getTrucks(page: number, status: string) {
    const res = await Http.get<TrucksResponseDTO>(`http://localhost:8080/v1/trucks?page=${page}&status=${status}`);
    return res.data;
  }

  async updateTruck(dto: UpdateTruckDTO, id: string) {
    const res = await Http.put<Truck>(`http://localhost:8080/v1/trucks/${id}`, dto);
    return res.data;
  }

}
