import { TruckDataSource } from "../DataSources/Truck/TruckDataSource";
import { Truck, UpdateTruckDTO } from "../../Domain/Models/Truck";
import { TruckRepository } from "../../Domain/Repositories/TruckRepository";
import { TrucksResponseDTO } from "../DTOs/TrucksResponseDTO";

export class TruckRepositoryImpl implements TruckRepository {
  datasource: TruckDataSource;

  constructor(datasource: TruckDataSource) {
    this.datasource = datasource;
  }

  async getTrucks(page: number, status: string): Promise<TrucksResponseDTO> {
    return await this.datasource.getTrucks(page, status);
  }

  async updateTruck(truck: UpdateTruckDTO, id: string): Promise<Truck> {
    return this.datasource.updateTruck(truck, id);
  }
}
