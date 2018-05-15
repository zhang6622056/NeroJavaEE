#!/bin/bash
#下载并解压redis
mkdir -p /softdownload/redis
cd /softdownload/redis
wget "http://download.redis.io/releases/redis-4.0.2.tar.gz"
tar -zxvf redis-4.0.2.tar.gz

#安装redis
cd redis-4.0.2
make && make install



#至此已完成安装，查看/usr/local/bin下自动生成的redis相关启动文件


#创建redis工作目录软连接，到/usr/local/software/redis下
mkdir -p /usr/local/software/redis
ln -s /softdownload/redis/redis-4.0.2 /usr/local/software/redis/


#修改配置文件，外网访问，守护进程.
cat  > /usr/local/software/redis/redis-4.0.2/redis.conf << EOF

# Redis configuration file example.
#
# Note that in order to read the configuration file, Redis must be
# started with the file path as first argument:
#
# ./redis-server /path/to/redis.conf
#bind 127.0.0.1
protected-mode no
port 6379
tcp-backlog 511
timeout 0
tcp-keepalive 300
daemonize yes
supervised no
pidfile /var/run/redis_6379.pid
loglevel notice
databases 16
always-show-logo yes
save 900 1
save 300 10
save 60 10000
stop-writes-on-bgsave-error yes
rdbcompression yes
rdbchecksum yes
dbfilename dump.rdb
dir ./
slave-serve-stale-data yes
slave-read-only yes
repl-diskless-sync no
repl-diskless-sync-delay 5
repl-disable-tcp-nodelay no
slave-priority 100
lazyfree-lazy-eviction no
lazyfree-lazy-expire no
lazyfree-lazy-server-del no
slave-lazy-flush no
appendonly no
appendfilename "appendonly.aof"
appendfsync everysec
no-appendfsync-on-rewrite no
auto-aof-rewrite-percentage 100
auto-aof-rewrite-min-size 64mb
aof-load-truncated yes
aof-use-rdb-preamble no
lua-time-limit 5000
slowlog-log-slower-than 10000
slowlog-max-len 128
notify-keyspace-events ""
hash-max-ziplist-entries 512
hash-max-ziplist-value 64
list-max-ziplist-size -2
list-compress-depth 0
set-max-intset-entries 512
zset-max-ziplist-entries 128
zset-max-ziplist-value 64
hll-sparse-max-bytes 3000
activerehashing yes
client-output-buffer-limit normal 0 0 0
client-output-buffer-limit slave 256mb 64mb 60
client-output-buffer-limit pubsub 32mb 8mb 60
hz 10
aof-rewrite-incremental-fsync yes
EOF


#尝试redis_init_script启动
mkdir -p /etc/redis
cp /usr/local/software/redis/redis-4.0.2/redis.conf /etc/redis/6379.conf
/usr/local/software/redis/redis-4.0.2/utils/redis_init_script start


#到此为止已经安装完了单机版的redis，telnet尝试连接一下。如不通，可从iptables或者服务器安全组下功夫找问题


#设置开机启动：
cp /usr/local/software/redis/redis-4.0.2/utils/redis_init_script /etc/init.d/redis_6379

sed -i '2c #chkconfig: 2345 10 90' /etc/init.d/redis_6379

#文件名将加入到service name 并被chkconfig命令识别
chkconfig --add /etc/init.d/redis_6379
chkconfig redis_6379 on
