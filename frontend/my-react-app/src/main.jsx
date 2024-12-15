import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import "./style.css";
import Login from "./Login.jsx";

import Buildings from "./components/Buildings.jsx";
import Discussions from "./Discussions.jsx";
import Building from "./components/Building";
import DiscussionPage from "./DiscussionPage.jsx";
import Home from "./Home.jsx";
import Layout from "./UserLayout.jsx";
import FirstPage from "./FirstPage.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <FirstPage />,
  },

  {
    path: "/:userid",
    element: <Layout />,
    errorElement: <h1>404 Not Found</h1>,
    children: [
      {
        index: true,
        element: <Home />,
      },
      {
        path: "buildings",
        element: <Buildings />,
      },
      {
        path: "buildings/:buildingId",
        element: <Building />,
      },
      {
        path: "buildings/:buildingId/discussions",
        element: <Discussions />,
      },
      {
        path: "buildings/:buildingId/discussions/:discussionId",
        element: <DiscussionPage />,
      },
    ],
  },
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/diss",
    element: <DiscussionPage />,
  }
]);

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>
);
