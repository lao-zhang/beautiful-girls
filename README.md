# beautiful-girls

##（1）写在前面

        看了《社交网络》之后，觉得Facemash这个点子很有意思，就产生了自己仿制一个的想法。奈
    何当时比较菜（比现在还菜），所以迟迟没有动手。后来接触了spring系框架之后，决定把这个东西
    给完成。后来接触了spring系框架之后，决定把这个东西给完成。
    
        整个项目做完也没用多少时间，因为项目结构确实很简单，功能也单一（正妹图二选一）。
        
        现在看来，还有很多可以优化的地方。从可玩性来讲，如果不能hack进教务处把全校女生的证件
    照爬下来的话，确实没什么人感兴趣，毕竟网上的正妹图大家都审美疲劳了。 从项目结构来讲，可以
    适量加入中间件来优化后台的操作流程，这个项目我并没有测试高并发下的实际运行情况，但是肯定是
    扛不住的。频繁的数据库操作肯定对性能影响很大，这一点待会儿看代码就能很清晰的发现。
    
        这两点等时机合适我会去落实，如果大家有什么好的想法和建议，欢迎随时和我交流。
    
##（2）整个项目
        
        为了方便讲解，我按照整个项目运行起来的样子，大致过一遍整个项目。
    
        1、进入主页后首先映入眼帘的是当前分数最高的图片。说到分数就不得不提评分标准，我使用的
    评分标准跟电影里的一样，也就是扎克基友在玻璃上写下的那个公式。
        我之前还特意去知乎上查了一下，上面很多人给出了详细的公式，并且给了合适的参数，我就直接
    照搬照抄了。具体的评分标准后面会讲，这里先不赘述。
        请不要被分数最高的正妹图吸引而忽略了图片下方的按钮与下拉框，这里也是我自己做的一个改进：
    用户可以选择要看的妹子图片的数量，如果图片库很大的话，从头至尾看完整个库的图片肯定需要一定时
    间，所以这里给出选项供大家选择，灵活看图。
        但是我的自作主张却导致了一个问题：按照用户的选择每次从整个图片库中随机选择图片来进行比对，
    那么每个妹子受比较的机会不一定均等，最后得出来的分数肯定也是有失偏颇的。虽然这涉及到统计学的问
    题，但是如果整个项目注重严谨的话，这个问题也有待解决。
    
  ![Image text](https://github.com/lao-zhang/beautiful-girls/blob/master/Beauty/img/1.png)
  
        2、选好图片数量后点击“begin”按钮，正式进入“选妹”阶段，点击你喜欢的妹子，那么另一个妹子
    会被pass掉，然后显示出一张新的图片。
    
  ![Image text](https://github.com/lao-zhang/beautiful-girls/blob/master/Beauty/img/2.png)
    
        现在讲讲评分标准，按照我的理解：这里并不是单纯的被选加分，落选扣分，加分和扣分的多少取决
    于两张图片的分数差，如果“丑小鸭”在一次选美中战胜了“黑天鹅”，那么“丑小鸭”得到的分数要比战胜同
    类所得分数要高得多。接下来我们看看知乎大神的讲解：
    
   ![Image text](https://github.com/lao-zhang/beautiful-girls/blob/master/Beauty/img/5.png)
   ![Image text](https://github.com/lao-zhang/beautiful-girls/blob/master/Beauty/img/4.png)
    
         3、反复进行选图之后，最后呈现出本次选美的最后胜利者（仅对你而言），也就是最符合你审美的
         妹子。这时你如果返回首页，发现你刚刚选出的那位妹子现在是全场分数最高，那么这能可能说明两点：
         1.你对妹子的高评分，让她暂时登上了榜首；
         2.在你同时操作的大部分网友们选出来的也是这个妹子。（总感觉这两点有重叠... ..）
    
   ![Image text](https://github.com/lao-zhang/beautiful-girls/blob/master/Beauty/img/3.png)
    
    整个项目到这里，完。
    
    
##（3）项目结构

    整个项目使用了ssm框架，基于xml配置，数据库使用了mysql，视图是jsp。
    
    在Beauty/src 目录下可以看到 Myapplicationcontext.xml和MySpringMVC.xml两个配置文件。
        Myapplicationcontext.xml里进行了spring的基本设置，
        如：激活注解、开启组件扫描，另外还进行了mybatis的一系列设置，如：数据库账号密码，连接池等等。
        
        MySpringMVC.xml里进行了springMVC的基本设置，如：开启对@controller注解的扫描，设置视图前后缀等等。
        
        这些都是spring框架的基本设置，可以根据自己的情况进行修改和增减。
        
        
     在Beauty/src/com/beau 目录下有五个包：controller、mapper、pojo、service、test，是整个项目的所有java代码，
     包结构也是符合springMVC基本法的。
        controller：控制器，负责所有的业务处理和页面跳转（返回视图）。
        mapper：mybatis相关，数据库查询语句和自定义数据库工具类。
        pojo：项目涉及到的对象。
        service：解决各个子问题的具体方法，会被controller调用。
        test：测试。
        
     所有源码均已上传，并做了适当的注释。
    
  
  

   
