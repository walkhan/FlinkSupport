# FlinkSupport应用配置
## Flink任务配置

```yaml
##########################################################
# FlinkSupport默认配置文件,包含以下内容:
# 1. Support相关变量配置
# 2. 大数据组件的ENV变量配置
# 3. Flink任务相关参数设置
# 4. 其它
##########################################################

HADOOP_HOME:
YARN_HOME:
HIVE_HOME:
FLINK_HOME:
FLINK_VERSION: 1.11.1
SCALA_VERSION: 2.11
HADOOP_USER_NAME: easylife

SUPPORT_TASK_LOGDIR: /tmp/flink_support/logs

flink:
  task:
    type: stream
    name: FlinkApplication
    common:
      parallelism: 1 #并行度
      restartMode: none #fixed-delay | failure-rate | none  默认fixed-delay
      restartNum: 1  #重启次数  默认3
      restartInterval: 30000  #重启延迟  默认30S
      restartFailMaxNum: 1 #最大重启失败次数
      queue: root.default
    batch:
      sessionTimeout:     #保存作业的中间结果的超时时间 暂未启用
    stream:
      timeCharacteristic:    #流处理的事件模式  默认processTime eventTime
    checkpoint:
      enable: false       #是否启用检查点
      interval: 60000         #检查点间隔  单位毫秒
      timeout: 60000       #检查点超时时间 单位毫秒
      mode: EXACTLY_ONCE #检查点模式: AT_LEAST_ONCE  EXACTLY_ONCE
      minInterval: 500 #最小检查点间隔 单位毫秒
      maxConcurrent: 1   #z最多有多少checkpoint可以在运行
      externalized:
        enable: false    #是否开启checkpoint的外部持久化
        cleanUp: DELETE_ON_CANCELLATION #DELETE_ON_CANCELLATION  自动删除   RETAIN_ON_CANCELLATION 保留
      onFail: true  #当checkpoint发生错误时,是否认为任务失败 true 失败  false 拒绝checkpoint继续任务
    stateBackend:
      type: Memory #三种 Memory  FileSystem  RocksDB
      async: true #仅在配置为Memory FileSystem 时生效 RocksDB默认为异步
      path:  #支持hdfs路径 或者本地文件路径 hdfs://namenode:40010/flink/checkpoints  file:///data/flink/checkpoints



```

## 应用配置

```
app:
  class:
  name: Support Application
  etlMode: false
  sqlMode: false
```



## ETL应用配置

```yaml
###########################################
# FlinkSupport-Etl模式模式配置文件
# 1. 定义插件
# 2. 重写默认应用配置文件
###########################################
flink:
  task: #Flink相关任务配置
    type: stream

app: #应用相关配置
  name: SupportEtlApplication
  etlMode: true
  sqlMode: false

etl:
  reader:
    name: ExampleReader #Reader插件
    class: com.weiwan.support.plugins.reader.ExampleReader
    parallelism: 1
    example:
      readereVar: 1000
  processer:
    name: ExampleProcesser #Processer插件
    class: com.weiwan.support.plugins.processer.ExampleProcesser
    parallelism: 1
    example:
      channelVar: channel_var
  writer:
    name: ExampleWriter #Writer插件
    class: com.weiwan.support.plugins.writer.ExampleWriter
    parallelism: 1
    example:
      writerVar: writer_var
```

## 其它

暂无

