<template>
  <div id="Login">
    <div id="wrapper" class="animate__animated animate__fadeIn">
      <h2>老八餐厅订单系统</h2>
      <img class="bg" src="../../static/images/bg.jpg" />
      <el-form
        :model="ruleForm"
        status-icon
        :rules="rules"
        ref="ruleForm"
        label-width="auto"
        class="form"
      >
        <el-form-item label="账号" prop="username">
          <el-input
            type="text"
            v-model="ruleForm.username"
            autocomplete="off"
            placeholder="请输入用户姓名"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pwd">
          <el-input
            type="password"
            v-model="ruleForm.pwd"
            autocomplete="off"
            placeholder="请输入账号密码"
          ></el-input>
        </el-form-item>
        <el-form-item class="submit">
          <el-button type="primary" @click="submitForm('ruleForm')"
            >登录</el-button
          >
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>



<script>
export default {
  name: "Login",
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        callback();
      }
    };
    var validateUsername = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入账号"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        username: "",
        pwd: "",
      },
      rules: {
        username: [{ validator: validateUsername, trigger: "blur" }],
        pwd: [{ validator: validatePass, trigger: "blur" }],
      },
    };
  },
  methods: {
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {

          this.apis
            .login(this.ruleForm.username, this.ruleForm.pwd)
            .then((res) => {
              // console.log(res);
              const data = res.data;
              if (data.status === 200) {
                // 存储数据
                sessionStorage.setItem("token", data.result);
                sessionStorage.setItem("username", this.ruleForm.username);
                this.$notify({
                  title: "登陆成功",
                  message: data.message,
                  type: "success",
                });
                // aghg
                this.$router.push({ name: "DashBoard" });
              } else if (data.status === 403) {
                this.$notify.error({
                  title: "登陆失败",
                  message: "请确保账号或者密码正确",
                });
              } else {
                this.$notify({
                  title: "系统提示",
                  message: "系统暂时出现问题，请稍后尝试",
                  type: "warning",
                });
              }
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
  },
};
</script>

<style scoped>
#Login {
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  height: 100vh;
  width: 100%;
  background: #f9f9f9;
}

#Login #wrapper {
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  box-sizing: border-box;
  width: 400px;
  height: 60%;
  background: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.32), 0 0 6px rgba(0, 0, 0, 0.24);
  border: 1px solid #e4ecf3;
  border-radius: 0.55rem;
  padding: 20px 25px;
}
#Login #wrapper .form {
  z-index: 999;
}
#Login #wrapper h2 {
  z-index: 999;
}
#Login #wrapper .bg {
  transform: skew(15deg, -10deg);
  z-index: 0;
  opacity: 0.3;
  filter: blur(0.4px) brightness(110%);
  position: absolute;
  height: 100%;
  bottom: 0;
  object-fit: cover;
}
</style>