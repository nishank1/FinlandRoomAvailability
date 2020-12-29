import React, { Component } from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik';
import RoomDataService from '../service/RoomDataService';

const INSTRUCTOR = 'finlandrooms'

class RoomComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            roomId: this.props.match.params.roomId,
            description: '',
            rent: null,
            image: null
        }

        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)
        this.fileSelectedHandler = this.fileSelectedHandler.bind(this);

    }

    componentDidMount() {

        console.log(this.state.roomId)

        if (this.state.roomId == -1) {
            return
        }

        RoomDataService.retrieveRoom(INSTRUCTOR, this.state.roomId)
            .then(response => this.setState({
                description: response.data.description,
                rent: response.data.rent
            }))
    }

    validate(values) {
        let errors = {}
        if (!values.description) {
            errors.description = 'Enter a Description'
        } else if (values.description.length < 5) {
            errors.description = 'Enter atleast 5 Characters in Description'
        }
        if(!values.rent) {
            errors.description = 'Enter Rent of the room'
        }

        return errors

    }
    fileSelectedHandler(event) {
        console.log(event.target.files[0]);
    }

    onSubmit(values) {
        let username = INSTRUCTOR

        let room = {
            roomId: values.roomId,
            description: values.description,
            rent: values.rent,
            image: values.image
        }

        if (this.state.roomId == -1) {
            RoomDataService.createRoom(username, room)
                .then(() => this.props.history.push('/rooms'))
        } else {
            RoomDataService.updateRoom(room.roomId, room)
                .then(() => this.props.history.push('/rooms'))
        }

        console.log(values);
    }
    render() {

        let { roomId, rent, description, image} = this.state

        return (
            <div>
                <h3>Room</h3>
                <div className="container">
                    <Formik
                        initialValues={{ roomId, description, rent, image }}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={this.validate}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="description" component="div"
                                        className="alert alert-warning" />
                                    <fieldset className="form-group">
                                        <label>RoomId</label>
                                        <Field className="form-control" type="text" name="roomId" disabled/>
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field className="form-control" type="text" name="description" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Rent</label>
                                        <Field className="form-control" type="text" name="rent" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Image</label>
                                        <Field className="form-control" type="file" name="image" onChange={this.fileSelectedHandler}/>
                                    </fieldset>
                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>

                </div>
            </div>
        )
    }

}

export default RoomComponent