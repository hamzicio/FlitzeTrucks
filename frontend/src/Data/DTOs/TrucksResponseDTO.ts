export interface TrucksResponseDTO {
    totalItems: number,
    items: Truck[],
    currentPage: number,
    totalPages: number
}

export interface Truck {
    id: number;
    truckName: string;
    status: string;
    latitude: number;
    longitude: number;
    photoUrl: string;
}
