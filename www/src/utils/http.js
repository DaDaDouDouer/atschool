import axios from 'axios'
import errorProcess from './errorProcess'

const config = {
  // `baseURL` will be prepended to `url` unless `url` is absolute.
  // It can be convenient to set `baseURL` for an instance of axios to pass relative URLs
  // to methods of that instance.
  baseURL: 'http://localhost:8080',

  // `transformRequest` allows changes to the request data before it is sent to the server
  // This is only applicable for request methods 'PUT', 'POST', and 'PATCH'
  // The last function in the array must return a string, an ArrayBuffer, or a Stream
  // transformRequest: [function (data) {
  //   // Do whatever you want to transform the data
  //
  //   return data
  // }],

  // `transformResponse` allows changes to the response data to be made before
  // it is passed to then/catch
  transformResponse: [function (data) {
    // Do whatever you want to transform the data
    console.warn('ajax response:', data)
    return data
  }, errorProcess],
  // `withCredentials` indicates whether or not cross-site Access-Control requests
  // should be made using credentials
  withCredentials: true // default
}

const instance = axios.create(config)

export default instance
