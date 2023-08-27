package com.hss.spi;

import com.hss.spi.service.ISpi;

import java.util.ServiceLoader;

/**
 * <p>
 * java spi demo
 * </p>
 *
 * @author Hss
 * @date 2023-08-27
 */
public class SpiDemo {

    public static void main(String[] args) {
        ServiceLoader<ISpi> spiServiceLoader = ServiceLoader.load(ISpi.class);
        for (ISpi spi : spiServiceLoader){
            spi.say();
        }
    }
}
