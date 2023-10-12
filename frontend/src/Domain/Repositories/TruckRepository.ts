import { TrucksResponseDTO } from "../../Data/DTOs/TrucksResponseDTO";
import { Truck, UpdateTruckDTO } from "../Models/Truck";

export interface TruckRepository {
  getTrucks(page:number, status:string): Promise<TrucksResponseDTO>;
  updateTruck(truck:UpdateTruckDTO, id: string): Promise<Truck>;
}
