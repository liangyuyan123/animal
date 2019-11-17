<style scoped>
  .layout-con {
    height: 100%;
    width: 100%;
  }

  .layout-logo{
  width: 200px;
  height: 45px;
  background: #5b6270;
  border-radius: 3px;
  float: left;
  position: relative;
  top: 9px;
  left: 5px;
  }

  .layout-nav{
      width: 100px;
      margin: 0 auto;
      margin-right: 20px;
      text-align: right;
  }

  .menu-item span {
    display: inline-block;
    overflow: hidden;
    width: 69px;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: bottom;
    transition: width .2s ease .2s;
  }

  .menu-item i {
    transform: translateX(0px);
    transition: font-size .2s ease, transform .2s ease;
    vertical-align: middle;
    font-size: 16px;
  }

  .collapsed-menu span {
    width: 0px;
    transition: width .2s ease;
  }

  .collapsed-menu i {
    transform: translateX(5px);
    transition: font-size .2s ease .2s, transform .2s ease .2s;
    vertical-align: middle;
    font-size: 22px;
  }

  .layout-ceiling-main {
    float: right;
    margin-right: 10px;
  }
  .layout-footer-center{
  text-align: center;
}

</style>
<template>
  <div class="layout">
    <Layout :style="{minHeight: '100vh'}">


        <Header>
          <Menu mode="horizontal" theme="dark" @on-select="test">
            <div class="layout-logo"></div>
            <div class="layout-nav">
              <MenuItem name="h-1-1">
               <Icon type="ios-power" />
                <span>注销</span>
              </MenuItem>
            </div>


          </Menu>
          <!-- <div class="layout-ceiling-main">

          </div> -->

        </Header>
        <Layout>
        <Sider collapsible :collapsed-width="78" v-model="isCollapsed">
          <Menu active-name="1-1" theme="dark" width="auto" :class="menuitemClasses" @on-select="test" accordion>
            <MenuItem name="1-1">
            <Icon type="md-book" />
              <span>宠物管理</span>
            </MenuItem>
            <MenuItem name="1-2">
            <Icon type="md-book" />
              <span>订单管理</span>
            </MenuItem>

            <MenuItem name="1-3">
            <Icon type="md-book" />
              <span>用户管理</span>
            </MenuItem>


          </Menu>
        </Sider>
        <Layout>
          <Content :style="{padding: '0 16px 16px'}">

              <Card>
                  <div style="height: 600px">
                      <router-view/>
                  </div>
              </Card>
          </Content>
          <Footer class="layout-footer-center">2018-9&copy;第二小组出版，版权归己所有，拒绝侵权 </Footer>
        </Layout>

      </Layout>
    </Layout>
  </div>
</template>
<script>
  import router from '@/router/index'

  export default {
    data() {
      return {
        isCollapsed: false,
        data: {
          testType: this.getTestType,
        },

      };
    },
    // 创建完成时
    created() {
    // localStorage.setItem("load",1);
    // this.$store.dispatch('findAllLesson');
    // this.$store.dispatch('findAllClass');
    this.$router.push('/Test'); //跳转到指定页面
    },

    methods: {
      test(name) {
        let data;
        switch (name) {


          case "1-1":
           router.push({ path: '/AdminPets' }) ;
            
            break;
          case "1-2":
          let data2 ={
            regionType: "forum"
          }
          data=data2;
          this.$store.dispatch('findRegion', {data});
            break;


          case "1-3":
          let data3={}
          data=data3;
          this.$store.dispatch('findAllCommonUser',{data});
            break;
          case "h-1-1":
            this.$store.dispatch('userLoginOut');
            break;

            default:
        }
      }

    },
    computed: {
      menuitemClasses: function () {
        return [
          'menu-item',
          this.isCollapsed ? 'collapsed-menu' : ''
        ]
      },

      getTestType: function () {
        //return this.$store.getters.getTestType
      },
    }
  }
</script>
