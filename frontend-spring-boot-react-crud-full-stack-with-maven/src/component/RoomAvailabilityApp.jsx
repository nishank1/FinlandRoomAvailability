import React, { Component } from 'react';
import ListRoomsComponent from './ListRoomsComponent';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import RoomComponent from './RoomComponent';

class RoomAvailabilityApp extends Component {
    render() {
        return (
            <Router>
                <>
                    <h1>Room Availibility in Finland</h1>
                    <Switch>
                        <Route path="/" exact component={ListRoomsComponent} />
                        <Route path="/rooms" exact component={ListRoomsComponent} />
                        <Route path="/rooms/:roomId" component={RoomComponent} />
                    </Switch>
                </>
            </Router>
        )
    }
}

export default RoomAvailabilityApp