import axios from 'axios'

const INSTRUCTOR = 'finlandrooms'
const COURSE_API_URL = 'http://127.0.0.1:8000'
const INSTRUCTOR_API_URL = `${COURSE_API_URL}/instructors/${INSTRUCTOR}`

class RoomDataService {

    retrieveAllRooms(name) {
        //console.log('executed service')
        return axios.get(`${INSTRUCTOR_API_URL}/rooms/`);
    }

    retrieveRoom(name, roomId) {
        //console.log('executed service')
        return axios.get(`${INSTRUCTOR_API_URL}/rooms/${roomId}`);
    }

    deleteRoom(name, roomId) {
        //console.log('executed service')
        return axios.delete(`${INSTRUCTOR_API_URL}/rooms/${roomId}`);
    }

    updateRoom(roomId, room) {
        //console.log('executed service')
        return axios.put(`${INSTRUCTOR_API_URL}/rooms/${roomId}`, room);
    }

    createRoom(name, room) {
        //console.log('executed service')
        return axios.post(`${INSTRUCTOR_API_URL}/room/`, room);
    }
}

export default new RoomDataService()