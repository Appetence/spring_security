package com.ribbon;
 
import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
 
public class RandomRule_Myself extends AbstractLoadBalancerRule {
 
     /*
     total = 0 // 当total==5以后，我们指针才能往下走，
     index = 0 // 当前对外提供服务的服务器地址，
     total需要重新置为零，但是已经达到过一个5次，我们的index = 1 */
 
    /* 总共被调用的次数，目前要求每台被调用5次 */
    private int total = 0;
    /* 当前提供服务的机器号 */
    private int currentIndex = 0;
    //返回那个服务器
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;
        //多线程时候用while判断，当线程苏醒后仍然会判断一次
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();
 
            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
            
            if (total < 5) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;//重新统计
                currentIndex++;	//切换服务，切换机器号
                if (currentIndex >= upList.size()) {//重新重o开始再次执行
                    currentIndex = 0;
                }
            }
 
 
            if (server == null) {
                Thread.yield();
                continue;
            }
 
            if (server.isAlive()) {
                return (server);
            }
 
            server = null;
            Thread.yield();
        }
 
        return server;
 
    }
 
    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }
 
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {}
 
}