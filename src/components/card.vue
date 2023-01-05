<template>
  <div id="card">
    <div id="imgBx">
      <img :src="link"  class="animate__animated animate__bounceIn animate__slow"/>
    </div>
    <div id="content">
      <span class="name">{{ dish.name }}</span>
      <div class="main">
        <p class="desc">{{ dish.descr }}</p>
        <strong class="price"
          >{{ dish.price }}<br /><svg
            t="1640262299720"
            class="icon"
            viewBox="0 0 1024 1024"
            version="1.1"
            xmlns="http://www.w3.org/2000/svg"
            p-id="3886"
            width="50"
            height="50"
          >
            <path
              d="M1005.63552 338.752l-320-320a64.064 64.064 0 0 0-106.432 26.304c-14.496 47.008-39.552 87.872-76.64 124.928-49.536 49.504-114.048 87.008-182.304 126.656-72.448 41.984-147.296 85.504-208.64 146.816C59.49152 495.648 24.00352 553.696 3.20352 621.088a64.064 64.064 0 0 0 15.872 64.192l320 320a64.064 64.064 0 0 0 106.432-26.368c14.528-47.008 39.584-87.872 76.704-124.928 49.504-49.504 113.984-86.944 182.304-126.56 72.384-42.048 147.264-85.568 208.576-146.88 52.128-52.128 87.616-110.24 108.448-177.632a64.128 64.128 0 0 0-15.904-64.16zM384.35552 960L64.35552 640c90.944-294.432 485.12-281.568 576-576l320.064 320C869.44352 678.368 475.26752 665.568 384.35552 960z"
              fill="#333333"
              p-id="3887"
            ></path>
            <path
              d="M626.33952 476.8c-10.432-8.736-20.928-14.688-31.488-17.632a91.648 91.648 0 0 0-31.616-3.36 113.28 113.28 0 0 0-32 7.328 439.36 439.36 0 0 0-32.448 14.016 1818.176 1818.176 0 0 0-51.552-57.376c7.744-7.008 15.264-10.56 22.496-10.816 7.264-0.32 14.24 0.448 20.864 2.112 6.752 1.696 12.928 3.136 18.624 4.256a17.216 17.216 0 0 0 15.136-3.808 21.248 21.248 0 0 0 7.552-15.424c0.32-6.304-2.048-12.448-7.328-18.432a41.376 41.376 0 0 0-24.64-14.176 76.064 76.064 0 0 0-29.76 0.672c-10.112 2.304-19.744 6.112-28.864 11.488s-16.448 10.88-21.888 16.256l-6.24-5.888a12.032 12.032 0 0 0-8.64-3.2 11.2 11.2 0 0 0-8.736 4.256 11.52 11.52 0 0 0-2.944 9.12 11.52 11.52 0 0 0 4.064 8.064c2.08 1.76 4.16 3.488 6.24 5.312-8.192 9.888-14.944 20.8-20.256 32.32a108.032 108.032 0 0 0-9.76 34.112c-1.248 11.2-0.064 21.44 3.36 30.944 3.424 9.568 9.76 17.696 19.008 25.376 15.072 12.512 32.8 17.824 53.376 16.64 20.512-1.248 42.624-7.36 66.4-20.128 18.88 21.824 37.824 43.488 56.736 63.616-8 6.752-15.008 10.624-21.184 11.872a33.12 33.12 0 0 1-16.672-0.32 53.024 53.024 0 0 1-13.888-6.688 97.536 97.536 0 0 0-12.64-7.488c-4.128-2.048-8.384-3.2-12.736-3.264s-8.992 2.048-14.112 6.432c-5.248 4.576-7.872 9.888-7.872 15.872 0 5.952 2.752 12 8.128 18.112 5.44 6.112 12.512 11.264 21.056 15.328s18.208 6.624 28.832 7.328a80 80 0 0 0 33.632-5.248c11.872-4.32 23.616-12.128 35.2-23.744 5.568 5.44 11.2 10.624 16.8 15.616a11.52 11.52 0 0 0 8.736 2.816 11.616 11.616 0 0 0 8.64-4.512 12.352 12.352 0 0 0 3.008-9.376 10.912 10.912 0 0 0-4-7.808 419.2 419.2 0 0 1-16.864-14.24c9.568-11.744 17.248-24.128 22.944-36.384 5.696-12.32 9.056-24.192 10.176-35.2a62.88 62.88 0 0 0-3.808-30.112c-3.584-9.184-9.952-17.056-19.072-24.64z m-178.912 21.696a31.072 31.072 0 0 1-23.872-9.312 23.456 23.456 0 0 1-6.24-10.304 32.128 32.128 0 0 1-1.248-13.376c0.448-4.8 1.888-9.824 4.384-14.88 2.368-5.056 5.888-10.112 10.368-15.008a1141.344 1141.344 0 0 1 48.64 52.128c-12.288 6.752-22.976 10.368-32.032 10.752z m150.944 64.064c-2.88 5.312-6.176 10.048-10.048 14.176a1307.616 1307.616 0 0 1-53.76-58.432c4.576-2.048 9.376-4.192 14.56-6.368s10.368-3.616 15.552-4.512c5.312-0.8 10.56-0.576 15.808 0.672 5.184 1.312 10.112 4.128 14.688 8.576 4.512 4.512 7.36 9.184 8.512 14.24 1.248 5.12 1.312 10.304 0.448 15.616a51.584 51.584 0 0 1-5.76 16.032zM471.29952 709.76h-0.064a574.4 574.4 0 0 0-57.6 49.696 467.584 467.584 0 0 0-46.752 54.368l-21.888 29.888 0.064 0.064a16.096 16.096 0 0 0 2.112 20.064 16.128 16.128 0 0 0 22.72 0 15.04 15.04 0 0 0 2.368-3.2l20.448-28c12.672-17.312 27.328-34.368 43.552-50.56a507.52 507.52 0 0 1 54.848-47.2l-0.064-0.064c0.576-0.448 1.12-0.8 1.632-1.312a16 16 0 0 0-21.376-23.744zM588.45152 246.88c-16.736 16.736-34.88 31.808-53.696 46.176a16.192 16.192 0 0 0-3.744 25.632c6.112 6.176 16 6.304 22.368 0.448l0.128 0.064c20-15.36 39.488-31.616 57.568-49.696a470.176 470.176 0 0 0 46.752-54.304l21.888-30.016-0.064-0.064a16.128 16.128 0 0 0-23.616-21.888 17.44 17.44 0 0 0-2.816 3.936l-21.248 29.12a432.448 432.448 0 0 1-43.52 50.592z"
              fill="#333333"
              p-id="3888"
            ></path></svg
        ></strong>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "card",
  props: {
    cuisine: Object,//规定子组件从父组件预期拿到的值的类型
  },
  data() {
    return {
      dish: this.cuisine,//一次性初始化
    };
  },
  watch: {
    // fasoghasjhgsah
    cuisine(n, o) {
      this.dish = n;
      o=this.dish;
    },
  },
  computed: {
    link() {
      return `http://localhost:8081/images/${this.dish.imgPath}`;
    },
  },
};
</script>

<style scoped>
#card {
  transition-duration: 0.4s;
  box-sizing: border-box;
  position: relative;
  width: 100%;
  height: 220px;
  margin-top: 30px;
  margin-bottom: 30px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
#card:nth-child(2n) {
  padding-right: 40px;
}
#card:nth-child(2n + 1) {
  padding-left: 130px;
}
#card:hover {
  transform: translateX(-10px);
}
#card #imgBx {
  display: flex;
  align-items: center;
  position: absolute;
  width: 140px;
  height: 105%;
  border-radius: 30%;
  z-index: 999;
  /* overflow: hidden; */
}
#card:nth-child(2n) #imgBx {
  right: 0;
}
#card:nth-child(2n + 1) #imgBx {
  left: 0;
}
#card:nth-child(4) #imgBx {
  height: 80%;
}
#card #imgBx img {
  height: 100%;
  object-fit: cover;
}
#card #content {
  position: relative;
  border: 1px solid #e3e8f7;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  background: #fff;
  border-radius: 8px;
  height: 90%;
  flex-grow: 1;
  overflow: hidden;
  display: flex;
  justify-content: center;
  align-items: center;
}
#card #content .main {
  display: flex;
  align-items: center;
  width: 90%;
  height: 90%;
}
#card #content .main .price {
  text-shadow: 2px 2px 10px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  color: #596275;
  padding: 10px;
  font-size: 40px;
}
#card:nth-child(2n + 1) #content .main {
  flex-direction: row;
}
#card:nth-child(2n) #content .main {
  flex-direction: row-reverse;
}
#card #content .main .desc {
  font-family: SimSun;
  width: 75%;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  text-align: justify;
  -webkit-line-clamp: 10;
  text-overflow: ellipsis;
  overflow: hidden;
}
#card:nth-child(2n + 1) #content .main .desc {
  padding-right: 20px;
  border-right: 6px dashed rgba(255, 195, 18, 0.6);
}
#card:nth-child(2n) #content .main .desc {
  padding-left: 20px;
  border-left: 6px dashed rgba(253, 167, 223, 0.4);
}
#card #content .name {
  z-index: 0;
  position: absolute;
  width: 500px;
  font-size: 220px;
  font-family: PMingLiU;
  font-weight: 800;
  color: #dcdde1;
  letter-spacing: 30px;
  opacity: 0.2;
}
#card:nth-child(2n + 1) #content {
  padding-left: 100px;
}
#card:nth-child(2n) #content {
  padding-right: 100px;
}
#card:nth-child(2n + 1) #content .name {
  transform: rotate(-10deg);
}
#card:nth-child(2n) #content .name {
  right: 150px;
  transform: rotate(10deg) translateY(-20px);
}
</style>