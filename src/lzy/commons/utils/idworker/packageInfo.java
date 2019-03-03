/*****************************************************************************************************************************************************
 * @desc idworker
 * idworker��һ��ID���ɹ��ߣ���������һ��ȫ��Ψһ�ĳ�����ID��Ҳ֧�ֲַ�ʽ�����µ�ʹ�á�idworker������Snowflake�㷨�����ڴ˻�������������ż�������ܣ������ڵͲ����Ļ���������ȫ��ż���������
 *
 * 1�� ���������µ�ʹ��
 * IdWorker idworker = IdWorkerFactory.create(0...15); long id = idworker.nextId();
 * 
 * 2�� �ֲ�ʽ������ʹ��
 * int index = getDistributiedIndex(); //��ȡ������������Ҫ�ⲿ����
 * IdWorker idworker = IdWorkerFactory.create(index); //��ȡһ��ΨһID 
 * long id = idworker.nextId();
 * 
 * @author lzy
 * @dateTime 2019��3��3�� ����2:35:35
 *****************************************************************************************************************************************************/
package lzy.commons.utils.idworker;

