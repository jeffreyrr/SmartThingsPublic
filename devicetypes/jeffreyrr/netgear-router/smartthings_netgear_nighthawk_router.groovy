/**
 *  Netgear Router
 *
 *  Copyright 2019 Jeffrey Rogiers
 *  Based on Ilker Aktuna Netgear Router Device Handler:
 *  https://github.com/mrmrmrmr1/SmartThingsPublic/blob/master/devicetypes/ilkeraktuna/netgear-router.src/netgear-router.groovy
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */

metadata {
    definition (name: "Netgear Nighthawk Router", namespace: "jeffreyrr", author: "Jeffrey Rogiers") {
        capability "Switch"
        capability "Refresh"
        capability "Polling"
        capability "Sensor"

        attribute "ip", "string"
        attribute "port", "string"
        attribute "username", "string"
        attribute "password", "string"

        attribute "GuestWifi2Ghz", "string"
        attribute "GuestWifi5Ghz", "string"
        attribute "5ghz", "string"
        attribute "2ghz", "string"
        attribute "Wifi2Ghz", "string"
        attribute "Wifi5Ghz", "string"
        attribute "w5ghz", "string"
        attribute "w2ghz", "string"

        command "WirelessOn"
        command "WirelessOff"
        command "WirelessOn5"
        command "WirelessOff5"
        command "GuestWirelessOn"
        command "GuestWirelessOff"
        command "GuestWirelessOn5"
        command "GuestWirelessOff5"
        command "GetAll"
        command "GetAttached"
        command "GetStats"
        command "Reboot"
        command "refresh"
        command "genGraph"
    }

    preferences {
        section {
            input title: "", description: "Netgear Nighthawk Router Control", displayDuringSetup: true, type: "paragraph", element: "paragraph"
            input("ip", "string", title:"LAN IP address", description: "LAN IP address", required: true, displayDuringSetup: true)
            input("port", "string", title:"LAN Port", description: "LAN Port", required: true, displayDuringSetup: true)
            input("username", "string", title:"Admin Username", description: "Case Sensitive", required: true, displayDuringSetup: true)
            input("password", "password", title:"Admin Password", description: "Case Sensitive", required: false, displayDuringSetup: true)
            input("ren", "bool", title:"Enable this if you want reboot button?", description: "Reboot Enable", required: false, displayDuringSetup: true)
        }
    }

    simulator {
        // TODO: define status and reply messages here
    }

    // UI tile definitions
    tiles(scale: 2) {
        wifiTile("GuestWifi5Ghz", "device.GuestWifi5Ghz", "GuestWirelessOn5", "GuestWirelessOff5")
        wifiTile("GuestWifi2Ghz", "device.GuestWifi2Ghz", "GuestWirelessOn", "GuestWirelessOff")
        wifiTile("Wifi5Ghz", "device.Wifi5Ghz", "WirelessOn5", "WirelessOff5")
        wifiTile("Wifi2Ghz", "device.Wifi2Ghz", "WirelessOn", "WirelessOff")

        standardTile("refresh", "device.power", inactiveLabel: false, decoration: "flat", width: 2, height: 1) {
            state "default", label:'Refresh All', action:"refresh.refresh", icon:"st.secondary.refresh"
        }
        valueTile("5ghz", "device.5ghz", decoration: "flat", width: 2, height: 1) {
            state ("default", label:'${currentValue}')
        }
        valueTile("2ghz", "device.2ghz", decoration: "flat", width: 2, height: 1) {
            state ("default", label:'${currentValue}')
        }
        valueTile("w5ghz", "device.w5ghz", decoration: "flat", width: 2, height: 1) {
            state ("default", label:'${currentValue}')
        }
        valueTile("w2ghz", "device.w2ghz", decoration: "flat", width: 2, height: 1) {
            state ("default", label:'${currentValue}')
        }
        standardTile( "refreshall", "device.power", decoration: "flat", width: 2, height: 1) {
            state "default", label:'Refresh Graph', action: "genGraph", icon:"st.secondary.refresh", nextState: "default"
        }
        standardTile( "attached", "device.attached", decoration: "flat", width: 2, height: 1) {
            state "default", label:'Refresh Devices', action: "GetAttached", icon:"st.secondary.refresh", nextState: "default"
            //state "default", label:'Get Attached Devices', action: "genGraph", icon:"st.secondary.refresh", nextState: "default"
        }

        deviceTile(1)
        deviceTile(2)
        deviceTile(3)
        deviceTile(4)
        deviceTile(5)
        deviceTile(6)
        deviceTile(7)
        deviceTile(8)
        deviceTile(9)
        deviceTile(10)
        deviceTile(11)
        deviceTile(12)
        deviceTile(13)
        deviceTile(14)
        deviceTile(15)
        deviceTile(16)
        deviceTile(17)
        deviceTile(18)
        deviceTile(19)
        deviceTile(20)

        standardTile("reboot", "device.reboot", inactiveLabel: false, decoration: "flat", width: 2, height: 1, canChangeIcon: true) {
            state "enabled", label: 'Reboot', action: "Reboot", icon: "st.samsung.da.RC_ic_power", backgroundColor: "#79b821"
            state "disabled", label: 'Reboot\n(disabled)', action: "", icon: "st.samsung.da.RC_ic_power", backgroundColor: "#ffffff"
        }

        carouselTile("trafficChart", "device.image", width: 6, height: 4) { }

        main "GuestWifi2Ghz"

        details([
            "GuestWifi5Ghz","5ghz","reboot","GuestWifi2Ghz","2ghz","refresh","Wifi5Ghz","w5ghz","refreshall","Wifi2Ghz","w2ghz","attached","trafficChart",
            "gadd1","gad1","gade1","gadf1","gadd2","gad2","gade2","gadf2","gadd3","gad3","gade3","gadf3","gadd4","gad4","gade4","gadf4","gadd5","gad5","gade5","gadf5",
            "gadd6","gad6","gade6","gadf6","gadd7","gad7","gade7","gadf7","gadd8","gad8","gade8","gadf8","gadd9","gad9","gade9","gadf9","gadd10","gad10","gade10","gadf10",
            "gadd11","gad11","gade11","gadf11","gadd12","gad12","gade12","gadf12","gadd13","gad13","gade13","gadf13","gadd14","gad14","gade14","gadf14","gadd15","gad15","gade15","gadf15",
            "gadd16","gad16","gade16","gadf16","gadd17","gad17","gade17","gadf17","gadd18","gad18","gade18","gadf18","gadd19","gad19","gade19","gadf19","gadd20","gad20","gade20","gadf20"
        ])

    }
}

def installed() {
    initialize()
}

def updated() {
//    unsubscribe()
    initialize()
}

def poll(){
    //refreshCmd()
    refresh()
}

def initialize() {
    //refreshCmd()
    state.listdl = []
    state.listul = []
    state.listt = []
    state.sdl = 0
    state.sul = 0
    state.min = 0
    state.sdle = 0
    state.sule = 0
    state.mine = 0
    refresh()
}

// parse events into attributes
def parse(String description) {
    def events = []
    def descMap = parseDescriptionAsMap(description)
    def body = new String(descMap["body"].decodeBase64())
    def xmlt = new groovy.util.XmlParser().parseText(body)

    parseAndPublishDeviceState("GuestWifi2Ghz", xmlt.'*'.'m:GetGuestAccessEnabledResponse'.NewGuestAccessEnabled.text())
    parseAndPublishDeviceState("GuestWifi5Ghz", xmlt.'*'.'m:Get5GGuestAccessEnabledResponse'.NewGuestAccessEnabled.text())
    parseAndPublishDeviceState("Wifi2Ghz", xmlt.'*'.'m:GetInfoResponse'.NewEnable.text())
    parseAndPublishDeviceState("Wifi5Ghz", xmlt.'*'.'m:Get5GInfoResponse'.NewEnable.text())

    parseAndPublichDeviceSSID("w5ghz", xmlt.'*'.'m:Get5GInfoResponse'.NewSSID.text())
    parseAndPublichDeviceSSID("w2ghz", xmlt.'*'.'m:GetInfoResponse'.NewSSID.text())
    parseAndPublichDeviceSSID("5ghz", xmlt.'*'.'m:Get5GGuestAccessNetworkInfoResponse'.NewSSID.text())
    parseAndPublichDeviceSSID("2ghz", xmlt.'*'.'m:GetGuestAccessNetworkInfoResponse'.NewSSID.text())

    processNewAttachedDevice(xmlt)

    calculateNetworkUsage(xmlt)
}

private parseAndPublishDeviceState(device, stateText) {
    def stateValue = (stateText == "1" ? "on" : "off")
    sendEvent(name: device, value: stateValue, isStateChange: true, displayed: false)
}

private parseAndPublichDeviceSSID(device, ssidText) {
    if (ssidText != null && ssidText != "") {
        sendEvent(name: device, value: ssidText, isStateChange: true, displayed: false)
    }
}

private processNewAttachedDevice(xmlt) {
    def newAttachedDeviceText = xmlt.'*'.'m:GetAttachDeviceResponse'.NewAttachDevice.text()

    if (newAttachedDeviceText != null && newAttachedDeviceText != "") {
        state.attacheddev = newAttachedDeviceText
        parsegad(newAttachedDeviceText)
    }
}

private calculateNetworkUsage(xmlt) {
    if (xmlt.'*'.'m:GetTrafficMeterStatisticsResponse'.NewTodayConnectionTime.text() != null && xmlt.'*'.'m:GetTrafficMeterStatisticsResponse'.NewTodayConnectionTime.text() != "") {
        def smin = xmlt.'*'.'m:GetTrafficMeterStatisticsResponse'.NewTodayConnectionTime.text()
        def sdl = xmlt.'*'.'m:GetTrafficMeterStatisticsResponse'.NewTodayDownload.text()
        def sul = xmlt.'*'.'m:GetTrafficMeterStatisticsResponse'.NewTodayUpload.text()
        def sminp = smin.split(":")

        state.min = sminp[1].toInteger() + sminp[0].toInteger() * 60
        state.sdl = sdl.tokenize(".")[0].toInteger()
        state.sul = sul.tokenize(".")[0].toInteger()

        if (state.sdle == 0) { state.sdle = state.sdl }
        if (state.sule == 0) { state.sule = state.sul }
        if (state.mine == 0) { state.mine = state.min }
        if (state.min == 0) { state.min = 1 }

        def dlf = state.sdl - state.sdle
        def ulf = state.sul - state.sule
        def mf = state.min - state.mine

        if (mf == 0) { mf = 1 }

        def tlist = []

        state.listdl.push(dlf * 8 / (60 * mf))

        for (int i = 1; i < 145; i++) {
            if (state.listdl[i] == null || state.listdl[i] < 0) {
                tlist.push(0)
            } else {
                tlist.push(state.listdl[i])
            }
        }

        state.listdl = tlist

        tlist = []
        state.listul.push(ulf * 8 / (60 * mf))

        for (int i = 1; i < 145; i++) {
            if (state.listul[i] == null || state.listul[i] < 0) {
                tlist.push(0)
            } else {
                tlist.push(state.listul[i])
            }
        }

        state.listul = tlist

        tlist = []

        state.listt.push(state.min - state.mine)

        for (int i = 1; i < 145; i++) {
            if (state.listt[i] == null) {
                tlist.push(0)
            } else {
                tlist.push(state.listt[i])
            }
        }

        state.listt=tlist

        /*
        log.debug "yeni dl $state.sdl"
        log.debug "eski dl $state.sdle"
        log.debug "yeni min $state.min"
        log.debug "eski min $state.mine"
        log.debug state.listdl

        log.debug state.sul
        log.debug state.min
        log.debug state.sule
        log.debug state.mine

        log.debug state.listul
        log.debug state.listdl
        */

        state.sdle = state.sdl
        state.sule = state.sul
        state.mine = state.min
        genGraph()
    }
}

private deviceTile(deviceNumber) {
    standardTile("gadd${deviceNumber}", "device.gadd${deviceNumber}", width: 1, height: 1) {
        state ("default", label:'', icon: "st.Electronics.electronics6", backgroundColor: "#ffffff")
        state ("wiredok", label:'', icon: "st.Electronics.electronics6", backgroundColor: "#79b821")
        state ("wirelessok", label:'', icon: "st.Entertainment.entertainment15", backgroundColor: "#79b821")
        state ("wirednok", label:'', icon: "st.Electronics.electronics6", backgroundColor: "#ff0000")
        state ("wirelessnok", label:'', icon: "st.Entertainment.entertainment15", backgroundColor: "#ff0000")
    }
    standardTile("gad${deviceNumber}", "device.gad${deviceNumber}", width: 2, height: 1) {
        state ("default", label:'${currentValue}')
    }
    standardTile("gade${deviceNumber}", "device.gade${deviceNumber}", width: 2, height: 1) {
        state ("default", label:'${currentValue}')
    }
    standardTile("gadf${deviceNumber}", "device.gadf${deviceNumber}", width: 1, height: 1) {
        state ("default", label:'${currentValue}')
    }
}
private wifiTile(apName, apDevice, apOnAction, apOffAction) {
    def apLabel = "${apName}\n${name}"
    def apIcon = "st.Kids.kids15"
    def backgroundOn = "#79b821"
    def backgroundOff = "#ffffff"

    standardTile(apName, apDevice, decoration: "flat", width: 2, height: 1, canChangeIcon: true){
        state "on", label: apLabel, action: apOffAction, icon: apIcon, backgroundColor: backgroundOn, nextState: "turningOff"
        state "off", label: apLabel, action: apOnAction, icon: apIcon, backgroundColor: backgroundOff, nextState: "turningOn"
        state "turningOn", label: apLabel, action: apOffAction, icon: apIcon, backgroundColor: backgroundOn, nextState: "turningOff"
        state "turningOff", label: apLabel, action: apOnAction, icon: apIcon, backgroundColor: backgroundOff, nextState: "turningOn"
    }
}

private parsegad(rororo) {
    def devlines = []
    //def devicelist
    //def tmpdev
    devlines = rororo.split('@')
    //devicelist="Name\tIPADDR\tMACADDR\tConnected\tAccess\n"
    for (int i = 1; i < devlines.length; i++){
        def linetmp = []
        linetmp = devlines[i].split(';')
        //devicelist=devicelist + linetmp[2] + "\t" + linetmp[1] + "\t" + linetmp[3] + "\t" + linetmp[4] + "\t" + linetmp[7] + "\n"
        //tmpdev=linetmp[2] + "\t" + linetmp[1] + "\t" + linetmp[3] + "\n"
        sendEvent(name: "gad$i", value: "${linetmp[2]}", isStateChange: true, displayed: false)
        sendEvent(name: "gade$i", value: "${linetmp[1]}", isStateChange: true, displayed: false)
        sendEvent(name: "gadf$i", value: "${linetmp[3]}", isStateChange: true, displayed: false)

        if (linetmp[4] == "wired" && linetmp[7] == "Allow") {
            sendEvent(name: "gadd$i", value: "wiredok", isStateChange: true, displayed: false)
        } else if (linetmp[4] == "wireless" && linetmp[7] == "Allow") {
            sendEvent(name: "gadd$i", value: "wirelessok", isStateChange: true, displayed: false)
        } else if (linetmp[4] == "wired" && linetmp[7] != "Allow") {
            sendEvent(name: "gadd$i", value: "wirednok", isStateChange: true, displayed: false)
        } else if (linetmp[4] == "wireless" && linetmp[7] != "Allow") {
            sendEvent(name: "gadd$i", value: "wirelessnok", isStateChange: true, displayed: false)
        }
    }
    //state.devl = devicelist
    //sendEvent(name: "gad", value: "$devicelist", isStateChange: true, displayed: false)
}

def parseDescriptionAsMap(description) {
    description.split(",").inject([:]) { map, param ->
        def nameAndValue = param.split(":")

        if (nameAndValue.length == 2) map += [(nameAndValue[0].trim()):nameAndValue[1].trim()]
        else map += [(nameAndValue[0].trim()):""]
    }
}

// handle commands
def on() {
    log.debug "Executing 'on'"
    // TODO: handle 'on' command
}

def off() {
    log.debug "Executing 'off'"
    // TODO: handle 'off' command
}

def WirelessOn5() {
    //log.debug "Executing 'GuestWirelessOn 5Ghz'"
    return [authrouter(), delay(9000), configStarted(), delay(9000), wifi5enable(), delay(9000), configFinished(), delay(9000), wifi5stat()]
}

def WirelessOff5() {
    //log.debug "Executing 'GuestWirelessOff 5Ghz'"
    return [authrouter(), delay(9800), configStarted(), delay(9800), wifi5disable(), delay(9800), configFinished(), delay(9000), wifi5stat()]
}

def WirelessOn() {
    //log.debug "Executing 'GuestWirelessOn 2Ghz'"
    return [authrouter(), delay(9000), configStarted(), delay(9000), wifi2enable(), delay(9000), configFinished(), delay(9000), wifi2stat()]
}

def WirelessOff() {
    //log.debug "Executing 'GuestWirelessOff 2Ghz'"
    return [authrouter(), delay(9800), configStarted(), delay(9800), wifi2disable(), delay(9800), configFinished(), delay(9000), wifi2stat()]
}

def GuestWirelessOn5() {
    //log.debug "Executing 'GuestWirelessOn 5Ghz'"
    return [authrouter(), delay(9000), configStarted(), delay(9000), gwon5(), delay(9000), configFinished(), delay(9000), gwget5(), delay(9000), gwinfo5()]
}

def GuestWirelessOff5() {
    //log.debug "Executing 'GuestWirelessOff 5Ghz'"
    return [authrouter(), delay(9800), configStarted(), delay(9800), gwoff5(), delay(9800), configFinished(), delay(9000), gwget5()]
}

def GuestWirelessOn() {
    //log.debug "Executing 'GuestWirelessOn 2Ghz'"
    return [authrouter(), delay(9000), configStarted(), delay(9000), gwon(), delay(9000), configFinished(), delay(9000), gwget(), delay(9000), gwinfo()]
}

def GuestWirelessOff() {
    //log.debug "Executing 'GuestWirelessOff 2Ghz'"
    return [authrouter(), delay(9800), configStarted(), delay(9800), gwoff(), delay(9800), configFinished(), delay(9000), gwget()]
}

def GetAttached() {
    return [authrouter(), delay(9800), getattacheddev()]
}

def GetStats() {
    return [authrouter(), delay(9800), getstats()]
}

def Reboot() {
    return [authrouter(), delay(9800), configStarted(), delay(9800), rebootoff(), delay(9800), configFinished()]
}

def refresh() {
    //log.debug "Executing refreshCmd"
    sendEvent(name: "reboot", value: "disabled", isStateChange: true, displayed: false)
    def host = ip
    def port = port
    def hosthex = convertIPtoHex(host)
    def porthex = convertPortToHex(port)
    //log.debug "The device id before update is: $device.deviceNetworkId"
    device.deviceNetworkId = "$hosthex:$porthex"
    //log.debug "The device id configured is: $device.deviceNetworkId"

    //return gwgetall()
    //return infoall
    //return GetAll()
    return [authrouter(), delay(1000), gwget(), delay(1000), gwget5(), delay(1000), gwinfo(), delay(1000), gwinfo5(), delay(1000), gwinfo5(), delay(1000), wifi2stat(), delay(1000), wifi5stat(), delay(1000), getstats()]

}

def GetAll() {
    state.lastcmd = "getall"
    return [authrouter(), delay(1000), gwget(), delay(1000), gwget5(), delay(1000), gwinfo(), delay(1000), gwinfo5(), delay(1000), wifi2stat(), delay(1000), wifi5stat()]
}

private getSOAPCommand(command) {
    return """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
    <SOAP-ENV:Envelope xmlns:SOAPSDK1="http://www.w3.org/2001/XMLSchema" xmlns:SOAPSDK2="http://www.w3.org/2001/XMLSchema-instance" xmlns:SOAPSDK3="http://schemas.xmlsoap.org/soap/encoding/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header>
    <SessionID>58DEE6006A88A967E89A</SessionID>
    </SOAP-ENV:Header><SOAP-ENV:Body>""" + getSOAPBody(command) + """</SOAP-ENV:Body></SOAP-ENV:Envelope>"""
}

private getSOAPBody(key) {
    def commandBodyList = [
        'GetGuestAccessEnabled' : '<M1:GetGuestAccessEnabled xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"></M1:GetGuestAccessEnabled>',
        'Get5GGuestAccessEnabled' : '<M1:Get5GGuestAccessEnabled xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"></M1:Get5GGuestAccessEnabled>',
        'GetAttachDevice' : '<M1:GetAttachDevice xmlns:M1="urn:NETGEAR-ROUTER:service:DeviceInfo:1"></M1:GetAttachDevice>',
        'GetTrafficMeterStatistics' : '<M1:GetTrafficMeterStatistics xmlns:M1="urn:NETGEAR-ROUTER:service:DeviceConfig:1"></M1:GetTrafficMeterStatistics>',
        'GetInfo' : '<M1:GetInfo xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"></M1:GetInfo>',
        'Get5GInfo' : '<M1:Get5GInfo xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"></M1:Get5GInfo>',
        'SetEnable' : '<M1:SetEnable xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"><NewEnable>1</NewEnable></M1:SetEnable>',
        'Set5GEnable' : '<M1:Set5GEnable xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"><NewEnable>1</NewEnable></M1:Set5GEnable>',
        'SetDisable' : '<M1:SetEnable xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"><NewEnable>0</NewEnable></M1:SetEnable>',
        'Set5GDisable' : '<M1:Set5GEnable xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"><NewEnable>0</NewEnable></M1:Set5GEnable>',
        'Reboot' : '<M1:Reboot xmlns:M1="urn:NETGEAR-ROUTER:service:DeviceConfig:1"></M1:Reboot>',
        'SetGuestAccessDisabled' : '<M1:SetGuestAccessEnabled xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"><NewGuestAccessEnabled>0</NewGuestAccessEnabled></M1:SetGuestAccessEnabled>',
        'SetGuestAccessEnabled' : '<M1:SetGuestAccessEnabled2 xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"><NewGuestAccessEnabled>1</NewGuestAccessEnabled></M1:SetGuestAccessEnabled2>',
        'GetGuestAccessNetworkInfo' : '<M1:GetGuestAccessNetworkInfo xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"></M1:GetGuestAccessNetworkInfo>',
        'Set5GGuestAccessDisabled' : '<M1:Set5GGuestAccessEnabled xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"><NewGuestAccessEnabled>0</NewGuestAccessEnabled></M1:Set5GGuestAccessEnabled>',
        'Set5GGuestAccessEnabled' : '<M1:Set5GGuestAccessEnabled2 xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"><NewGuestAccessEnabled>1</NewGuestAccessEnabled></M1:Set5GGuestAccessEnabled2>',
        'Get5GGuestAccessNetworkInfo' : '<M1:Get5GGuestAccessNetworkInfo xmlns:M1="urn:NETGEAR-ROUTER:service:WLANConfiguration:1"></M1:Get5GGuestAccessNetworkInfo>',
    ]
    return commandBodyList[key]
)

private getSOAPAction(key) {
    def actionList = [
        'GetGuestAccessEnabled' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetGuestAccessEnabled',
        'Get5GGuestAccessEnabled' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#Get5GGuestAccessEnabled',
        'GetAttachDevice' : 'urn:NETGEAR-ROUTER:service:DeviceInfo:1#GetAttachDevice',
        'GetTrafficMeterStatistics' : 'urn:NETGEAR-ROUTER:service:DeviceConfig:1#GetTrafficMeterStatistics',
        'GetInfo' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetInfo',
        'Get5GInfo' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#Get5GInfo',
        'SetEnable' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetEnable',
        'Set5GEnable' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#Set5GEnable',
        'SetDisable' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetEnable',
        'Set5GDisable' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#Set5GEnable',
        'Reboot' : 'urn:NETGEAR-ROUTER:service:DeviceConfig:1#Reboot',
        'SetGuestAccessDisabled' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetGuestAccessEnabled',
        'SetGuestAccessEnabled' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#SetGuestAccessEnabled2',
        'GetGuestAccessNetworkInfo' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#GetGuestAccessNetworkInfo',
        'Set5GGuestAccessDisabled' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#Set5GGuestAccessEnabled',
        'Set5GGuestAccessEnabled' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#Set5GGuestAccessEnabled2',
        'Get5GGuestAccessNetworkInfo' : 'urn:NETGEAR-ROUTER:service:WLANConfiguration:1#Get5GGuestAccessNetworkInfo',
    ]
    return actionList[key]
}

private gwgetall() {
    requestSOAPCommand("GetGuestAccessEnabled", "gwgetall")
    new physicalgraph.device.HubAction("delay 2000")
    requestSOAPCommand("Get5GGuestAccessEnabled")
}

private getattacheddev() {
    requestSOAPCommand("GetAttachDevice")
}

private getstats() {
    requestSOAPCommand("GetTrafficMeterStatistics")
}

private wifi2stat() {
    requestSOAPCommand("GetInfo")
}

private wifi5stat() {
    requestSOAPCommand("Get5GInfo")
}

private wifi2enable() {
    requestSOAPCommand("SetEnable")
}

private wifi5enable() {
    requestSOAPCommand("Set5GEnable")
}


private wifi2disable() {
    requestSOAPCommand("SetDisable")
}

private wifi5disable() {
    requestSOAPCommand("Set5GDisable")
}

private rebootoff() {
    requestSOAPCommand("Reboot")
}

private gwoff() {
    requestSOAPCommand("SetGuestAccessDisabled")
}

private gwon() {
    requestSOAPCommand("SetGuestAccessEnabled")
}

private gwget() {
    requestSOAPCommand("GetGuestAccessEnabled", "gwget")
}

private gwinfo() {
    requestSOAPCommand("GetGuestAccessNetworkInfo", "gwget")
}

private gwoff5() {
    requestSOAPCommand("Set5GGuestAccessDisabled")
}

private gwon5() {
    requestSOAPCommand("Set5GGuestAccessEnabled")
}

private gwget5() {
    requestSOAPCommand("Get5GGuestAccessEnabled", "gwget5")
}

private gwinfo5() {
    requestSOAPCommand("Get5GGuestAccessNetworkInfo", "gwget5")
}

private authrouter() {
    def hubaction
    try {
        hubaction = new physicalgraph.device.HubSoapAction(
            path:    "/soap/server_sa/",
            urn:     'urn:NETGEAR-ROUTER:service:ParentalControl:1',
            action:  "Authenticate",
            body:    ["NewPassword": "$password", "NewUsername": "$username" ],
            headers: [Host: "$ip:$port", CONNECTION: "close"]
        )
    } catch (Exception e) {
        log.debug e
    }
    return hubaction
}

private configStarted() {
    state.lastcmd = "configStarted"
    def hubaction
    try {
        hubaction = new physicalgraph.device.HubSoapAction(
            path:    "/soap/server_sa/",
            urn:     'urn:NETGEAR-ROUTER:service:DeviceConfig:1',
            action:  "ConfigurationStarted",
            body:    ["NewSessionID":"58DEE6006A88A967E89A" ],
            headers: [Host: "$ip:$port", CONNECTION: "keep-alive"]
        )
    } catch (Exception e) {
        log.debug e
    }
    return hubaction
}

private configFinished() {
    state.lastcmd = "configFinished"
    def hubaction
    try {
        hubaction = new physicalgraph.device.HubSoapAction(
            path:    "/soap/server_sa/",
            urn:     'urn:NETGEAR-ROUTER:service:DeviceConfig:1',
            action:  "ConfigurationFinished",
            body:    ["NewStatus":"ChangesApplied" ],
            headers: [Host: "$ip:$port", CONNECTION: "keep-alive"]
        )
    } catch (Exception e) {
        log.debug e
    }
    return hubaction
}

private delay(long time) {
    new physicalgraph.device.HubAction("delay $time")
}

private requestSOAPCommand(command, lastcmd = null) {
    if (lastcmd) {
        state.lastcmd = lastcmd
    }

    def headers = [:]
    headers.put("HOST", "$ip:$port")
    headers.put("SOAPAction", getSOAPAction(command))
    headers.put("content-type", "text/xml;charset=utf-8")

    try {
        def hubAction = new physicalgraph.device.HubAction(
            method: "POST",
            path: "/soap/server_sa/",
            headers: headers,
            body: getSOAPCommand(command)
        )
        hubAction
    } catch (Exception e) {
        log.debug "Hit Exception $e on $hubAction"
    }
}

private String convertIPtoHex(ipAddress) {
    String hex = ipAddress.tokenize('.').collect { String.format('%02x', it.toInteger()) }.join()
    //log.debug "IP address entered is $ipAddress and the converted hex code is $hex"
    return hex
}

private String convertPortToHex(port) {
    String hexport = port.toString().format('%04x', port.toInteger())
    //log.debug hexport
    return hexport
}

// gets the address of the Hub
private getCallBackAddress() {
    return device.hub.getDataValue("localIP") + ":" + device.hub.getDataValue("localSrvPortTCP")
}

// gets the address of the device
private getHostAddress() {
    def ip = getDataValue("ip")
    def port = getDataValue("port")

    if (!ip || !port) {
        def parts = device.deviceNetworkId.split(":")
        if (parts.length == 2) {
            ip = parts[0]
            port = parts[1]
        } else {
            log.warn "Can't figure out ip and port for device: ${device.id}"
        }
    }

    //log.debug "Using IP: $ip and port: $port for device: ${device.id}"
    return convertHexToIP(ip) + ":" + convertHexToInt(port)
}

private Integer convertHexToInt(hex) {
    return Integer.parseInt(hex,16)
}

private String convertHexToIP(hex) {
    return [convertHexToInt(hex[0..1]),convertHexToInt(hex[2..3]),convertHexToInt(hex[4..5]),convertHexToInt(hex[6..7])].join(".")
}


def genGraph() {
    def dl ="t:"
    def ul ="t:"
    def tt ="t:"
    for (int i = 0; i < 143; i++){
        dl = dl + state.listdl[i] + ","
    }

    dl = dl + state.listdl[143] + "|"

    for (int i = 0; i < 143; i++){
        dl = dl + state.listul[i] + ","
    }

    dl = dl + state.listul[143]

    def maxx = Math.round(state.listdl.max())

    def aralik = maxx/5

   def podParams = [
      //uri: "https://chart.googleapis.com",
      uri: "https://image-charts.com",
      path: "/chart",
      query: [cht: "lc", chd: dl, chs: "400x250", chof: "gif", chxt: "x,y", chco: "00FF00,0000FF", chtt: "Traffic", chts:"AAAAAA,15", chxr:"0,0,144,1|1,0,"+maxx+","+aralik, ],
      contentType: 'image/gif'
    ]

    httpGet(podParams) { resp ->
        //log.debug resp.data
        saveImage(resp.data)
    }
    //log.debug "Created new graph"
}

def saveImage(image) {
    //log.trace "Saving image to S3"
    // Send the image to an App who wants to consume it via an event as a Base64 String
    def bytes = image.buf
    //log.debug "JPEG Data Size: ${bytes.size()}"
    String str = bytes.encodeBase64()
    sendEvent(name: "imageDataJpeg", value: str, displayed: false, isStateChange: true)
    // Now save it to the S3 cloud, do this in the end since it removes the data from the object leaving it empty
    storeImage(getPictureName(), image)
    return null
}

private getPictureName() {
    def pictureUuid = java.util.UUID.randomUUID().toString().replaceAll('-', '')
    "image" + "_$pictureUuid" + ".jpg"
}
