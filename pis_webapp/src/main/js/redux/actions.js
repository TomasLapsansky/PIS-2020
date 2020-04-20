import {LOAD_USER_LIST, UPDATE_USER} from "./actionTypes";

export const loadUserList = userArray => ({
    type: LOAD_USER_LIST,
    payload: {
        users: userArray
    }
});

export const updateUser = user => ({
    type: UPDATE_USER,
    payload: {
        user: user
    }
});