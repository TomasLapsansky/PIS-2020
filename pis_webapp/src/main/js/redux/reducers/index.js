import { combineReducers } from "redux";

import sidebar from "./sidebar";
import userList from "./userList";
import user from "./user";
import productList from "./productList";
import product from "./product";
import images from "./images";

export default combineReducers({ sidebar, userList, user, productList, product, images });