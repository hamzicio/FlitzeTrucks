import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { TrucksPage } from "./Presentation/UI/Pages/TrucksPage";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { UpdateTruckForm } from './Presentation/Truck/UpdateTruckForm';

const queryClient = new QueryClient();

const router = createBrowserRouter([
  {
    path: "/",
    element: <TrucksPage />,
  },
  {
    path: "/trucks",
    element: <TrucksPage />,
  },
  {
    path: "/trucks/:id",
    element: <UpdateTruckForm />,
  },
]);


function App() {
  return (
    <div className="App">
      <QueryClientProvider client={queryClient}>
        <RouterProvider router={router} />
      </QueryClientProvider>
    </div>
  );
}

export default App;
