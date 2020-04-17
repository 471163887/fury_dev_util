package com.brilliant.fury.task.base;

/**
 * 例如：
 *
 * @Resource private RoundRobinJedisPool jedisPool;
 *
 * public boolean isFirst(String key, int expireAt) {
 * try (Jedis jedis = jedisPool.getResource()) {
 * long first = jedis.incrBy(key, 1);
 * if (first == 1) {
 * jedis.expire(key, expireAt);
 * return true;
 * } else {
 * return false;
 * }
 * }
 * }
 */

public interface TaskCoordinater {

    boolean isFirst(String key, int expireAt);

}
