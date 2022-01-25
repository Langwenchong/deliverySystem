// 读取api.js内部定义的请求方法
import * as apis from './api.js'
// 暴露给外部以便调用，此时所有的api方法整合到了一起形成一个对象命名为apis
export default apis

