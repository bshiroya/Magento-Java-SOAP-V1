package com.connector.magento;

import com.connector.magento.soap.MagentoSoapClient;
import com.connector.magento.soap.SoapClient;

/**
 * based on source code from k5
 * http://www.magentocommerce.com/boards/viewthread/37982/
 *
 * @author Rahul Revawala <revawala.rahul@gmail.com>
 *
 * You are free to use it under the terms of the GNU General Public License
 */

/*
 * Magento Core API
 * http://www.magentocommerce.com/support/magento_core_api
 */

public class Connection {

    protected SoapClient client = null;

    public Connection() {
        client = MagentoSoapClient.getInstance();
    }
}

