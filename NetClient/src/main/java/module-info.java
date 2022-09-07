module ru.knyazev.NetClient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires io.netty.codec;
    requires ru.knyazev.NetCore;
    requires lombok;
    requires org.slf4j;

    opens ru.knyazev.cloud to javafx.fxml;
    exports ru.knyazev.cloud;
    exports ru.knyazev.cloud.controllers;
    opens ru.knyazev.cloud.controllers to javafx.fxml;
}