/*****************************************************************************************************************************************************
 * @desc idworker
 * idworker是一个ID生成工具，可以生成一个全局唯一的长整形ID。也支持分布式环境下的使用。idworker采用了Snowflake算法，并在此基础上增加了奇偶抖动功能，避免在低并发的环境下生成全是偶数的情况。
 *
 * 1、 单机环境下的使用
 * IdWorker idworker = IdWorkerFactory.create(0...15); long id = idworker.nextId();
 * 
 * 2、 分布式环境下使用
 * int index = getDistributiedIndex(); //获取分配索引，需要外部配置
 * IdWorker idworker = IdWorkerFactory.create(index); //获取一个唯一ID 
 * long id = idworker.nextId();
 * 
 * @author lzy
 * @dateTime 2019年3月3日 下午2:35:35
 *****************************************************************************************************************************************************/
package lzy.commons.utils.idworker;


