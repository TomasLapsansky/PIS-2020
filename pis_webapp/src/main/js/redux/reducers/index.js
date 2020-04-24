import { combineReducers } from "redux";

import sidebar from "./admin/sidebar";
import userList from "./admin/userList";
import user from "./admin/user";
import productList from "./admin/productList";
import product from "./admin/product";
import images from "./admin/images";
import activeProductImage from "./frontend/activeProductImage";

import categoryListSidebar from "./frontend/categoriesSidebar";

export default combineReducers(
{ sidebar,
        userList,
        user,
        productList,
        product,
        images,
        categoryListSidebar,
        activeProductImage
    });