# MvpBase
一个好用的MVP架构，使用者无需关心mvp的具体实现，简单继承几个类即可实现，另外还
包含一个支持Fragmeng懒加载的BaseFragment。

·支持普通的mvc架构开发，简单封装了BaseActivity，使用时继承即可。
·支持基于MVP模式的开发，使用时只需继承BaseMapActivity即可。
·简单封装了Fragment，继承BaseFragment即可，默认不开启懒加载，需要时手动开启。
·对Fragment对MVP的支持，继承BaseMvpFragment即可


如何使用：

compile 'com.jzw.mvp:mvpbase:1.3'

1.普通使用方式 ：继承BaseActivity

    public class MainActivity extends BaseActivity {
      @Override
      public int getLayoutId() {
          return R.layout.activity_main;
      }
      @Override
      public void initView(Bundle savedInstanceState) {
  
          findViewById(R.id.btn_mvp).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  startActivity(LoginActivity.class);
              }
          });
  
          findViewById(R.id.btn_frgment).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  startActivity(LazyFragmentActivity.class);
              }
          });
      }
    }
    
2.MVP模式：继承BaseMvpActivity
    
    public class LoginActivity extends BaseMvpActivity<ILoginView, LoginPresenter> implements ILoginView {
        @Override
        public int getLayoutId() {
            return R.layout.act_login;
        }
    
        @Override
        public void initView(Bundle savedInstanceState) {
            //初始化views
            findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //登陆
                    presenter.login("jzw", "123456");
                }
            });
    
        }
    
        @Override
        public void showLoadding() {
            //在这里显示加载对话框
        }
    
        @Override
        public void hideLoadding() {
            //在这里隐藏对话框
        }
    
        @Override
        public LoginPresenter initPresenter() {
            //初始化presenter
            return new LoginPresenter();
        }
    
        @Override
        public void loginSuccess(String userid) {
            //登陆成功回掉到这里，更新UI 显示数据
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
        }
    }
    
    继承时传入两个泛型，一个是View接口类型，一个presenter类，同时要实现View接口。上面的
    代码我使用登陆做了一个演示，View接口为ILogingView，presenter为LoginPresenter。
    其中view接口继承BaseView
        public interface ILoginView extends BaseView {
                  //登陆成功后更新UI回掉方法
                  void loginSuccess(String userid);
              }
              
     其中presenter继承BasePresenter
         public class LoginPresenter extends BasePresenter<ILoginView> {
         
             private LoginModle modle;
         
             @Override
             public void init() {
                 modle = new LoginModle();
             }
         
             @Override
             public void release() {
                 if (modle != null) {
                     modle = null;
                 }
             }
         
              //登陆方法，在这里使用model实现登陆逻辑
             public void login(String user, String pwd) {
                 getMvpView().showLoadding();
         
                 modle.loginUser(user, pwd);
                 getMvpView().loginSuccess(user);
         
                 getMvpView().hideLoadding();
             }
         }
      modle集成BaseModle
          public class LoginModle extends BaseModle {
              @Override
              public Activity getView() {
                  return null;
              }
          
              @Override
              public BasePresenter getPresenter() {
                  return null;
              }
               
               //真正的登陆逻辑
              public void loginUser(String userId, String pwd) {
                  System.out.println("登陆》》");
              }
          }

3.Fragment的懒加载

      Fragment1 fragment1 = new Fragment1();
             //开启懒加载的支持，默认不不开启
             fragment1.openLazyLoad(true);  
               
               
    下面是Fragment1的具体实现
       public class Fragment1 extends BaseFragment {
           private String TAG = "Fragment1>>";
       
           @Override
           public int getLayoutId() {
               return R.layout.fragment1;
           }
       
           @Override
           public void initView(View rootView) {
               Log.d(TAG, "初始化Fragment1");
           }
           @Override
           public void lazyLoadData() {
               Log.d(TAG, "Fragment1懒加载数据");
               Toast.makeText(getActivity(), "Fragment 1", Toast.LENGTH_SHORT).show();
           }
       
           @Override
           public void setUserVisibleHint(boolean isVisibleToUser) {
               Log.d(TAG, "Fragment1>>isVisibleToUser>>   " + isVisibleToUser);
               super.setUserVisibleHint(isVisibleToUser);
           }
       }
       
       如果开启了懒加载，则会回掉lazyLoadData()这个方法，在这里请求数据，否则不执行，
       除非手动调用，默认情况下没有开启懒加载模式，所以请求数据等操作就放在initView中
       去做。

额外在BaseActivity中提供了四个方法

    public void setInitContentView(boolean init){
        initContentView=init;
    }
    public void setInitViews(boolean init){
        initViews=init;
    }
    public boolean isInitContentView(){
        return initContentView;
    }
    public boolean isInitViews(){
        return initViews;
    }
    
    这四个方法分别对应setContentView()和initViews()这两个方法，默认不用关心，如果调用者在
    使用时有特殊的需求，比如自定义一个BaseActivity继承BaseMvpActivity或者BaseActivity，对
    setContentView和initViewsiew方法调用中间会有一些逻辑处理就可以使用上面提供的方法
    在子类中动态调用setContentView和initViews方法而避免子类和父类调用两次这两个方法。如下
    
    public abstract class DSMvpActivity<V, P extends BasePresenter<V>> extends BaseMvpActivity<V,P> {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            setContentView(getLayoutId());
            //加入butterKnife
            ButterKnife.bind(this);
            initView(savedInstanceState);
            setInitContentView(true);
            setInitViews(true);
            super.onCreate(savedInstanceState);
        }
    }
    
    上面的例子 需要在setContentView后initViews之间初始化butterKnife，就可以这样做。
    
好用的Retrofit配合Rxjava的请求库
https://github.com/jingzhanwu/RetrofitRxjavaClient

Android 开发工具集，包含文件，bitmap，数据库，权限，日期，时间UI等常见操作的工具类，能
大大提升开发效率
https://github.com/jingzhanwu/DevUtils

欢迎大家提问题和意见。
