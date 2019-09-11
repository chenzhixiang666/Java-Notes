package com.practice.note.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream学习
 * Created with IDEA
 * author:zhiXiang-Chen
 * Date:2019/9/11
 * Time:23:48
 */
public class StreamStudy {
    public static void main(String[] args) {

        //参数集合
        List<String> selectOrderList = new ArrayList();
        //返回数据的集合
        List<String> orders = new ArrayList();

        int applyIdSelectSize = 500;
        int limit = (selectOrderList.size() + applyIdSelectSize - 1) / applyIdSelectSize;
        Stream.iterate(0, n -> n + 1).limit(limit).forEach(a -> {
            //获取后面1000条中的前500条
            // 拿到这个参数的流的 （a * applyIdSelectSize）后面的数据  .limit（applyIdSelectSize）->后面数据的500条  .collect(Collectors.toList()->组成一个toList
            List<String> applyOrderEntities = selectOrderList.stream().skip(a * applyIdSelectSize).limit(applyIdSelectSize).collect(Collectors.toList());
            List<String> orderByOrderIds = orderDao.getOrderByOrderIds(applyOrderEntities);
            orders.addAll(orderByOrderIds);
        });

    }
}
