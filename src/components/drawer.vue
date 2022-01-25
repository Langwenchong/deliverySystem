<template>
  <div id="drawer">
    <h2>----- 菜品图片 -----</h2>
    <el-upload
      class="upload"
      :show-file-list="true"
      ref="coverImageUpload"
      drag
      action="a"
      :multiple="false"
      :auto-upload="false"
      :limit="1"
      :before-upload="beforeUpload"
      accept=".png,  .jpg, "
    >
      <i class="el-icon-upload"></i>
      <div class="el-upload__text">
        将图片拖到此处，或
        <em>点击上传</em>
      </div>
    </el-upload>
    <h2>----- 菜品信息 -----</h2>
    <div style="margin-top: 15px">
      <el-input
        placeholder="请输入菜品名称"
        v-model="name"
        maxlength="10"
        show-word-limit
      >
        <template slot="prepend">菜品名称</template>
      </el-input>
    </div>
    <h3>请输入菜品简介</h3>
    <div style="margin: 20px 0">
      <el-input
        type="textarea"
        placeholder="请输入菜品介绍"
        v-model="desc"
        maxlength="150"
        show-word-limit
      >
        <template slot="prepend">菜品介绍</template>
      </el-input>
    </div>
    <h3>请选择菜品定价</h3>
    <div style="margin: 20px 0">
      <el-slider v-model="price" show-input> </el-slider>
    </div>
    <el-button type="primary" @click="submit">添加菜品</el-button>
  </div>
</template>


<script>
export default {
  name: "drawer",
  data() {
    return {
      coverImage: null,
      name: "",
      desc: "",
      price: 0,
    };
  },
  methods: {
    beforeUpload(file) {
      // console.log(file);
      this.coverImage = file;
    },
    submit() {
      this.$refs.coverImageUpload.submit();
      if (this.coverImage === null) {
        this.$message.error("请选择上传一张菜品图片");
        return;
      }
      if (this.name === `` || this.desc === ``) {
        this.$message.error("请保证菜品名称和简介填写完整");
        return;
      }
      if (this.price === 0) {
        this.$message.error("请保证菜品价格不为0￥");
        return;
      }
      console.log(this.name);
      this.apis
        .addMenu(this.name, this.desc, this.price, this.coverImage)
        .then((res) => {
          //   console.log(res);
          if (res.status === 200) {
            this.name = ``;
            this.desc = ``;
            this.price = 0;
            this.coverImage = null;
            const resObj = res.data.result;
            this.$emit("updateMenu", resObj);
          }
        });
    },
  },
};
</script>

<style scoped>
#drawer {
  background: #f9f9f9;
  box-sizing: border-box;
  padding: 30px;
  width: 100%;
  height: 100%;
  flex-direction: column;
  align-items: center;
}
#drawer .upload {
  display: flex;
  flex-direction: column;
  align-items: center;
}

#drawer h2,
h3 {
  display: flex;
  justify-content: center;
}
</style>