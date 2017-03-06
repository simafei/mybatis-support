package cn.simafei.mybatis.util;

/**
 * 工具类
 */
public class CloseableUtil {
  private CloseableUtil() {
  }

  public static void closeQuietly(AutoCloseable c) {
    if (c != null) {
      try {
        c.close();
      } catch (Exception ignored) {
      }
    }
  }
}
