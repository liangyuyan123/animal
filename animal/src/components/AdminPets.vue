<template>
  <div>
      <i-button type="primary" @click="showAdminPets()">新增</i-button>

      <dl  v-for="pet in pets">
      	<dt class="demo-upload-list">
      	<img :src="pet.productImage" width="245px" height="245px">
        <div class="demo-upload-list-cover">
          <Icon type="ios-eye-outline" @click="showAdminPets2(pet)"></Icon>
          <Icon type="ios-trash-outline" @click="handleRemove(pet.id)"></Icon>
        </div>
      	</dt>
      	<dd>
      	<p>{{pet.productName}}</p>
      	</dd>
      	<dd>
      	<p>{{pet.productPrice}}RMB</p>
      	</dd>
      </dl>

    <Modal v-model="visibleAdminPets"  title="新增页面">
      <i-form ref="formPets" :model="formPets"  :label-width="80">
             <Form-item label="宠物名称" prop="productName">
                 <i-input v-model="formPets.productName" placeholder="请输入宠物名称"></i-input>
             </Form-item>

             <Form-item label="宠物价格" prop="productPrice">
                 <i-input v-model="formPets.productPrice" placeholder="请输入价格"></i-input>
             </Form-item>

             <Form-item label="宠物数量" prop="productAccount">
                 <i-input v-model="formPets.productAccount" placeholder="请输入数量"></i-input>
             </Form-item>

             <Form-item label="描述" prop="productDescription">
                 <i-input type="textarea" v-model="formPets.productDescription" placeholder="添加宠物描述"></i-input>
             </Form-item>
            <Form-item label="宠物图片">
              <Upload
              :on-success="handleSuccess"
              action="/api/image/photoUpload">
                      <i-button  icon="ios-cloud-upload-outline" height="20px" width="20px"></i-button>
              </Upload>
              <img :src=formPets.productImage width="45px" height="45px">
            </Form-item>

             <Form-item label="宠物类型" prop="productType">
                 <i-input v-model="formPets.productType" placeholder="添加宠物类型"></i-input>
             </Form-item>
             <Form-item label="宠物编号" prop="productId">
                 <i-input  v-model="formPets.productId" placeholder="添加宠物编号"></i-input>
             </Form-item>

             <Form-item>
                 <i-button type="primary" @click="handleSubmit('formPets')">保存</i-button>
                 <i-button type="primary" @click="handleReset('formPets')" style="margin-left: 8px">取消</i-button>
             </Form-item>
         </i-form>
         <div slot="footer"></div>
    </Modal>

    <Modal v-model="visibleAdminPets2"  title="编辑页面">
      <i-form ref="formPets2" :model="formPets2"  :label-width="80">
             <Form-item label="宠物名称" prop="productName">
                 <i-input v-model="formPets2.productName" placeholder="请输入宠物名称"></i-input>
             </Form-item>

             <Form-item label="宠物价格" prop="productPrice">
                 <i-input v-model="formPets2.productPrice" placeholder="请输入价格"></i-input>
             </Form-item>

             <Form-item label="宠物数量" prop="productAccount">
                 <i-input v-model="formPets2.productAccount" placeholder="请输入数量"></i-input>
             </Form-item>

             <Form-item label="描述" prop="productDescription">
                 <i-input type="textarea" v-model="formPets2.productDescription" placeholder="添加宠物描述"></i-input>
             </Form-item>
            <Form-item label="宠物图片">

              <Upload
              :on-success="handleSuccess2"
              action="/api/image/photoUpload">
                      <i-button  icon="ios-cloud-upload-outline" height="20px" width="20px"></i-button>
              </Upload>
              <img :src=formPets2.productImage width="45px" height="45px">

            </Form-item>

             <Form-item label="宠物类型" prop="productType">
                 <i-input v-model="formPets2.productType" placeholder="添加宠物类型"></i-input>
             </Form-item>
             <Form-item label="宠物编号" prop="productId">
                 <i-input  v-model="formPets2.productId" placeholder="添加宠物编号"></i-input>
             </Form-item>

             <Form-item>
                 <i-button type="primary" @click="handleView('formPets2')">保存</i-button>
                 <i-button type="primary" @click="handleReset('formPets2')" style="margin-left: 8px">取消</i-button>
             </Form-item>
         </i-form>
         <div slot="footer"></div>
    </Modal>



  </div>

</template>

<script>
  import axios from 'axios'
  import {Modal} from 'iview'
  export default {
          components:{
                      Modal
                  },
                  data () {
                      return {
                        //初始化显示数据绑定
                         pets: [{}],
                         //新增绑定数据
                         formPets: {
                                            productName: '',
                                            productPrice:'',
                                            productAccount: '',
                                            productDescription: '',
                                            productImage: '',
                                            productType:'',
                                            productId:''
                                        },
                          //修改绑定数据
                          formPets2: {
                                             productName: '',
                                             productPrice:'',
                                             productAccount: '',
                                             productDescription: '',
                                             productImage: '',
                                             productType:'',
                                             productId:''
                                         },
                          //新增页面是否展示
                         visibleAdminPets: false,
                         //修改页面是否展示
                         visibleAdminPets2:false,
                                        }

  },

  // 创建完成时
  created() {
    this.findPets();
  },
  methods:{
//新增产品信息
    showAdminPets: function () {
                    this.visibleAdminPets= true;
                },
                
    handleSubmit (name) {
    
                  this.$refs[name].validate((valid) => {
                      if (valid) {
                        const axios = require('axios');
    
                        axios({
                            headers: {
                                'Content-Type': 'application/json',
                            },
                            method: 'post',
                            url: '/api/product/insert',
                            data: this.formPets,
    
                        })
                        this.visibleAdminPets=false;
                        this.findPets();
                      } else {
                              this.$Message.info('提交失败');
                      }
                  })
    
    
    },
    
    handleSuccess (res, file) {
                   // 因为上传过程为实例，这里模拟添加 url
                   this.formPets.productImage=file.response
                    console.log(file)
               },
               
      //修改产品信息
    showAdminPets2: function (pet) {
                    this.visibleAdminPets2=true;
                    this.formPets2=pet;

                },
                
                
  
    handleView (name) {
        
      this.$refs[name].validate((valid) => {
          if (valid) {
            const axios = require('axios');
        
            axios({
                headers: {
                    'Content-Type': 'application/json',
                },
                method: 'post',
                url: '/api/product/updateById',
                data: this.formPets2,
        
            })
            this.visibleAdminPets2=false;
            this.findPets();
          } else {
                  this.$Message.info('提交失败');
          }
      })
      console.log(this.formpets2)
    },
    
    
    
    handleSuccess2 (res, file) {
                   // 因为上传过程为实例，这里模拟添加 url
                   this.formPets2.productImage=file.response
                    console.log(file)
               },
   
  //查询产品
    findPets(){
       var ahtis=this
      const axios = require('axios');

      axios.get('/api/product/selectAll')
      .then(function (response) {
            ahtis.pets=response.data;
      })
      .catch(function (error) {
       	    console.log(error);
      });

     console.log(this.pets);
    },



    // 删除产品
    handleRemove (petId) {

      const axios = require('axios');

      axios.get('/api/product/deleteById',{
        params:{
          "id":petId
        }
      })
      .then(function (response) {
            console.log("成功删除！")
            this.findPets();
      })
      .catch(function (error) {
       	    console.log(error);
      });
    }


    }
  }
</script>

<style>
   .demo-upload-list{
          display: inline-block;
          width: 200px;
          height: 200px;
          text-align: center;
          line-height: 60px;
          border: 1px solid transparent;
          border-radius: 4px;
          overflow: hidden;
          background: #fff;
          position: relative;
          box-shadow: 0 1px 1px rgba(0,0,0,.2);
          margin-right: 4px;
      }
      .demo-upload-list img{
          width: 100%;
          height: 100%;
      }
      .demo-upload-list-cover{
          display: none;
          position: absolute;
          top: 0;
          bottom: 0;
          left: 0;
          right: 0;
          background: rgba(0,0,0,.6);
      }
      .demo-upload-list:hover .demo-upload-list-cover{
          display: block;
      }
      .demo-upload-list-cover i{
          color: #fff;
          font-size: 20px;
          cursor: pointer;
          margin: 0 2px;
      }
</style>
