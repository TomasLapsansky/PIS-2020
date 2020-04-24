import {LOAD_CATEGORIES, SET_ACTIVE_PRODUCT_IMAGE} from "../actionTypes";

export const loadCategories = categoryArray => ({
    type: LOAD_CATEGORIES,
    payload: {
        categories: categoryArray
    }
});

export const setActiveProductImage = image => ({
    type: SET_ACTIVE_PRODUCT_IMAGE,
    payload : {
        image: image
    }
});

