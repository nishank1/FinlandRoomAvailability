import React, { Component } from 'react'
import RoomDataService from '../service/RoomDataService';

const INSTRUCTOR = 'finlandrooms'

class ListRoomsComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            rooms: [],
            message: null
        }
        this.deleteRoomClicked = this.deleteRoomClicked.bind(this)
        this.updateRoomClicked = this.updateRoomClicked.bind(this)
        this.addRoomClicked = this.addRoomClicked.bind(this)
        this.refreshRooms = this.refreshRooms.bind(this)
    }

    componentDidMount() {
        this.refreshRooms();
    }

    refreshRooms() {
        RoomDataService.retrieveAllRooms(INSTRUCTOR)//HARDCODED
            .then(
                response => {
                    //console.log(response);
                    this.setState({ rooms: response.data })
                }
            )
    }

    deleteRoomClicked(roomId) {
        RoomDataService.deleteRoom(INSTRUCTOR, roomId)
            .then(
                response => {
                    this.setState({ message: `Delete of room ${roomId} Successful` })
                    this.refreshRooms()
                }
            )

    }

    addRoomClicked() {
        this.props.history.push(`/rooms/-1`)
    }

    updateRoomClicked(roomId) {
        console.log('update ' + roomId)
        //RoomDataService.updateRoom(INSTRUCTOR, this.state.rooms[roomId])
        this.props.history.push(`/rooms/${roomId}`)
    }

    render() {
        console.log('render')
        return (
            <div className="container">
                <h3>All Rooms</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>RoomId</th>
                                <th>Description</th>
                                <th>Rent</th>
                                <th>Image</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.rooms.map(
                                    room =>
                                        <tr key={room.roomId}>
                                            <td>{room.roomId}</td>
                                            <td>{room.description}</td>
                                            <td>{room.rent} £ per month</td>
                                            <td>{room.image}</td>
                                            <td><button className="btn btn-success" onClick={() => this.updateRoomClicked(room.roomId)}>Update</button></td>
                                            <td><button className="btn btn-warning" onClick={() => this.deleteRoomClicked(room.roomId)}>Delete</button></td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success" onClick={this.addRoomClicked}>Add</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default ListRoomsComponent