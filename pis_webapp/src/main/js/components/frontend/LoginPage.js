import React from "react";
import {connect} from "react-redux";
import Header from "./partial/Header";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { updateLoginUser } from "../../redux/actions/frontendActions";

class LoginPage extends React.Component {

    constructor(props) {
        super(props);
        const user = Object.assign({}, {
           username: null,
           password: null,
        });
        this.props.updateLoginUser(user);
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    static mapStateToProps = state => {
        return {
            user: state.userLogin.user
        }
    }

    handleChange(event) {
        event.preventDefault();

        let user = this.props.user;

        switch (event.target.id) {
            case 'username':
                user.username = event.target.value;
                this.props.updateLoginUser(user);
                break;
            case 'password':
                user.password = event.target.value;
                this.props.updateLoginUser(user);
                break;
            default:
                break;
        }

        this.forceUpdate();
    }

    handleSubmit(event) {
        event.preventDefault();

        const data = new FormData(this.form)
        fetch('/perform_login', {
            method: 'POST',
            body: new URLSearchParams(data)
        })
            .then(v => {
                if(v.redirected) window.location = v.url
            })
            .catch(e => console.warn(e))

        console.log(data);
    }

    render() {
        return(
            <div>
                <Header/>
                <div id="main-content">
                    <div id="content-holder">
                        <div id="login-page">
                            <Form onSubmit={ (e) => this.handleSubmit(e)} ref={fm => {this.form=fm}} >
                                <Form.Group>
                                    <Form.Label>Prihlasovacie meno</Form.Label>
                                    <Form.Control type="text"
                                                  id="username"
                                                  name="username"
                                                  onChange={ (e) => this.handleChange(e)}
                                                  value={this.props.user.username || ''} />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Heslo</Form.Label>
                                    <Form.Control type="password"
                                                  id="password"
                                                  name="password"
                                                  onChange={ (e) =>  this.handleChange(e)}
                                                  value={this.props.user.password || ''} />
                                </Form.Group>
                                <Form.Group>
                                    <Button variant="primary" type="submit">Prihlásiť</Button>
                                </Form.Group>
                            </Form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export default connect(
    LoginPage.mapStateToProps,
    { updateLoginUser }
)(LoginPage)