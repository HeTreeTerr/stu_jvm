package com.hss.spi.service.impl;

import com.hss.spi.service.ISpi;

/**
 * <p>
 *
 * </p>
 *
 * @author Hss
 * @date 2023-08-27
 */
public class SecondSpiImpl implements ISpi {

    @Override
    public void say() {
        System.out.println("second spi impl...");
    }
}
