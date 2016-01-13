# mediaVolume
ionic cordova plugin media volume 


1).  安装mediaVolume。

方法一： 在线安装

    cordova plugin add  https://github.com/zhaoxinpeng/mediaVolume.git

方法二：下载到本地再安装

使用git命令将mediaVolume插件下载的本地,将这个目录标记为`$mediaVolume_dir`


    git clone https://github.com/zhaoxinpeng/mediaVolume.git
    cordova plugin add $mediaVolume_dir


###示例

1. 设置媒体音量大小0-100
  ```
    window.plugins.mediaVolume.setVol(vol);
  ```
2.  获取当前媒体音量大小
```
    window.plugins.mediaVolume.getVol(
      function(data){
        alert(JSON.stringify(data));
        //data.current 当前音量
        //data.max 系统最大音量
      },
      function(error){
        alert(error);
    });
```


