import axios from 'axios'


// 默认接口头部公有的ip地址
// 因此使用本地回环地址127.0.0.1同时默认是80端口
// axios.defaults.baseURL = 'http://1.117.169.85:8081';
axios.defaults.baseURL = '/apis';
// axios.defaults.baseURL = 'http://api.cheeseburgerim.space';

// http request拦截器 添加一个请求拦截器
axios.interceptors.request.use(function (config) {

  config.headers['Content-Type'] = "multipart/form-data"
  // 
  let token = sessionStorage.getItem("token");

  if (token) {
    //将token放到请求头发送给服务器,将tokenkey放在请求头中
    config.headers.token = token;
  }
  return config;
}, function (error) {
  // Do something with request error
  return Promise.reject(error);
});


//下面写请求方法
export const login = (username, pwd) => {
  let fd = new FormData();
  fd.append("username", username);
  fd.append("password", pwd)
  return axios.post('/api/user/login', fd)
}

export const getMenu = () => {
  return axios.get('/api/menu/get')
}

export const addMenu = (name, desc, price, image) => {
  var fd = new FormData();
  fd.append('name', name);
  fd.append('descr', desc);
  fd.append('price', price);
  fd.append('image', image);
  return axios.post('/api/menu/add', fd);

}
