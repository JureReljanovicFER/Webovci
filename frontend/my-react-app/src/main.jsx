import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import "./style.css";
import Login from "./Login.jsx";

import Buildings from "./components/Buildings.jsx";
import Discussions from "./Discussions.jsx";
import Building from './components/Building';
import DiscussionPage from "./DiscussionPage.jsx";
import Home from "./Home.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
    errorElement: <h1>404 Not Found</h1>,
  },
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/buildings/:buildingId",
    element: <Building/>,
  },
  {
    path: "/buildings",
    element: <Buildings />,
  },
  {
    path: "buildings/:buildingId/discussions",
    element: <Discussions />,
  },
  {
    path: "buildings/:buildingId/discussions/:discussionId",
    element: <DiscussionPage />,
  },
]);

createRoot(document.getElementById("root")).render(
  <StrictMode>
    
    <RouterProvider router={router} />
  </StrictMode>
);
