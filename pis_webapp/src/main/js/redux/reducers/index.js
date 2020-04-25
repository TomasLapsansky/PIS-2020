import { combineReducers } from "redux";

import sidebar from "./admin/sidebar";
import userList from "./admin/userList";
import user from "./admin/user";
import productList from "./admin/productList";
import product from "./admin/product";
import images from "./admin/images";
import activeProductImage from "./frontend/activeProductImage";
import userCart from "./frontend/cart";
import categoryListSidebar from "./frontend/categoriesSidebar";
import order from "./frontend/order";
import categoryList from "./admin/categoryList";
import category from "./admin/category";

export default combineReducers(
{ sidebar,
        userList,
        user,
        productList,
        product,
        images,
        categoryList,
        category,
        categoryListSidebar,
        activeProductImage,
        userCart,
        order
    });