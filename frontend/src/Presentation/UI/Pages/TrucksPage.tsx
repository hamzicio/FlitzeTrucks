
import { TruckList } from "../../Truck/TrucksList";
import { Layout } from "../Components/Layout";

export function TrucksPage() {
  return (
    <Layout>
      <main>
        <h1>Trucks</h1>
        <TruckList />
      </main>
    </Layout>
  );
}
