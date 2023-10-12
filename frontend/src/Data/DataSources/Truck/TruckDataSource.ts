import { Truck, UpdateTruckDTO } from "../../../Domain/Models/Truck";
import { TrucksResponseDTO } from "../../DTOs/TrucksResponseDTO";

export interface TruckDataSource {
  getTrucks(page: number, status: string): Promise<TrucksResponseDTO>;
  updateTruck(truck: UpdateTruckDTO, id: string): Promise<Truck>;
}
