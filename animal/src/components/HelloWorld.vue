<style scoped>
    .layout{
        border: 1px solid #d7dde4;
        background: #f5f7f9;
    }
    .layout-logo{
        width: 100px;
        height: 30px;
        background: #5b6270;
        border-radius: 3px;
        float: left;
        position: relative;
        top: 15px;
        left: 20px;
    }
    .layout-nav{
        width: 420px;
        margin: 0 auto;
    }
    .layout-assistant{
        width: 300px;
        margin: 0 auto;
        height: inherit;
    }
    .layout-breadcrumb{
        padding: 10px 15px 0;
    }
    .layout-content{
        /* min-height: 200px; */
        /* margin: 15px; */
        overflow: hidden;
        background: #fff;
        border-radius: 4px;
		font-size:15px
    }
    .layout-content-main{
        padding: 10px;
    }
    .layout-copy{
        text-align: center;
        padding: 10px 0 20px;
        color: #9ea7b4;
		
    }
	
	.pet{
		overflow:hidden;
	}
	
	
	dl {
	    float: left;
	    width: 180px;
	    margin: 10px 10px 0 0;
	    transition: all .2s linear;
	}
	 dt {
	     display: block;
	 }
	 
	 .hot_pet_cont dl dd {
	     background: #efefef;
	     border-top: none;
	     text-align: center;
	     height: 34px;
	     font: 14px/34px "Microsoft YaHei";
	     overflow: hidden;
	     text-overflow: ellipsis;
	     white-space: nowrap;
	     padding: 0 5px;
	 }
		
</style>
<template>
    <div class="layout">
        <Menu mode="horizontal" theme="dark" active-key="1">
            <div class="layout-logo"></div>
            <div class="layout-nav">
                <Menu-item key="1">
                    <Icon type="ios-navigate"></Icon>
                    导航一
                </Menu-item>
                <Menu-item key="2">
                    <Icon type="ios-keypad"></Icon>
                    导航二
                </Menu-item>
                <Menu-item key="3">
                    <Icon type="ios-analytics"></Icon>
                    导航三
                </Menu-item>
                <Menu-item key="4">
                    <Icon type="ios-paper"></Icon>
                    导航四
                </Menu-item>
            </div>
        </Menu>
        <Menu mode="horizontal" active-key="1">
            <div class="layout-assistant">
                <Menu-item key="1">二级导航</Menu-item>
                <Menu-item key="2">二级导航</Menu-item>
                <Menu-item key="3">二级导航</Menu-item>
            </div>
        </Menu>
        <div class="layout-breadcrumb">
            <Breadcrumb>
                <Breadcrumb-item href="#">首页</Breadcrumb-item>
                <Breadcrumb-item href="#">应用中心</Breadcrumb-item>
                <Breadcrumb-item>某应用</Breadcrumb-item>
            </Breadcrumb>
        </div>
		<i-input v-model="findtext" placeholder="请输入..." style="width: 300px"></i-input>
	    <i-button type="primary" shape="circle" icon="ios-search" @click="search"></i-button>
          
        <div class="layout-content">
			
                   
						<dl class="pet" v-for="dog in dogList">
							<dt>
							<img :src="dog.url" width="245px" height="245px">
							</dt>
							<dd> 
							<p>{{dog.name}}</p>
							</dd>
							<dd>
							<p>{{dog.price}}RMB</p>
							</dd>
						</dl>
        </div>
        <div class="layout-copy">
            2011-2016 &copy; TalkingData
        </div>
    </div>
</template>
<script>
    export default {
            data () {
                return {
					findtext:"",
                    dogList: [
                        {
                            name: '哈士奇',
							
                            url: 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1795859307,2340469476&fm=26&gp=0.jpg',
                            price:1800
                        },
                        {
                            name: '阿拉斯加',
                            url: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569044774440&di=c737a0973784ef540d452528e29ae012&imgtype=0&src=http%3A%2F%2Fpic2.58cdn.com.cn%2Fzhuanzh%2Fn_v292baf9a21b9341939e55f57ef4015622.jpg%3Fw%3D750%26h%3D0',
                            price:2000,
					
                        },
                        {
                            name: '柴犬',
                            url: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569044929092&di=19ea3e118797f4177b56e30fccf38795&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201806%2F22%2F20180622161630_XKRBk.jpeg',
                            price:500,
						
                        },
                        {
                            name: '中华田园犬',
                            url: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569044866651&di=827209505c80a7b8151f21724d1db72c&imgtype=0&src=http%3A%2F%2Fgss0.baidu.com%2F-vo3dSag_xI4khGko9WTAnF6hhy%2Fzhidao%2Fpic%2Fitem%2Fdc54564e9258d109fef8ca52d358ccbf6c814d32.jpg',
                            price:250
                        },
                        {
                            name: '萨摩耶',
                            url: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569045004618&di=3f529c9a3df965214fe1d85b3d9aae71&imgtype=0&src=http%3A%2F%2Fpic1.58cdn.com.cn%2Fzhuanzh%2Fn_v2a86d733a4b27464cb4ec612d179cb4bf.jpg%3Fw%3D750%26h%3D0',
                             price:2600
                        },
                        {
                            name: '八哥犬',
                            url: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569045057294&di=9e6e971343ab4eb4068e9aad69a9ac38&imgtype=0&src=http%3A%2F%2Fwww.goupuzi.com%2Fimages%2Fbreed%2F16%2FHeadDesc.jpg',
                           price:880
                        },
                       
                        {
                            name: '腊肠犬',
                            url: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569045354642&di=85f1029e6804014484d9a24ea9f8a8be&imgtype=0&src=http%3A%2F%2Fwww.cndog.net%2Fdog_photo_big%2F2011-11%2F12%2F1293633-624.jpg',
                         price:999
                        }
                    ]
                }
            },
            
			 methods:{
				 search:function(){
					 this.dogList.map((item)=>{
						  if(this.findtext===item.name){
							 var arry2=[];
							 arry2.push(item);
							 this.dogList=arry2;
						  }
						  
					 })
					 
				 
				 
			 }
			 }
        }
</script>
