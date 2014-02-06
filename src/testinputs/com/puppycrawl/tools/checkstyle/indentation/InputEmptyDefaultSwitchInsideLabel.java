public class InputEmptyDefaultSwitchInsideLabel {
    private void fooBar() {
    loop:
    while (true) {
      switch (1) {
      default:
      }
    }
    }
}