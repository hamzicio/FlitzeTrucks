export interface Truck {
  id: number;
  truckName: string;
  status: string;
  latitude: number;
  longitude: number;
  photoUrl: string;

}

export interface UpdateTruckDTO {
  status: string;
  latitude: number;
  longitude: number;
}
