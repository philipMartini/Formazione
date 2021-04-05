
/**
 * CrunchifyHelloWorldCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */

    package cruncify.com.web.service;

    /**
     *  CrunchifyHelloWorldCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CrunchifyHelloWorldCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CrunchifyHelloWorldCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CrunchifyHelloWorldCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for addValue method
            * override this method for handling normal response from addValue operation
            */
           public void receiveResultaddValue(
                    cruncify.com.web.service.CrunchifyHelloWorldStub.AddValueResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addValue operation
           */
            public void receiveErroraddValue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for subtractValue method
            * override this method for handling normal response from subtractValue operation
            */
           public void receiveResultsubtractValue(
                    cruncify.com.web.service.CrunchifyHelloWorldStub.SubtractValueResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from subtractValue operation
           */
            public void receiveErrorsubtractValue(java.lang.Exception e) {
            }
                


    }
    