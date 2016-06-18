/*
 * Copyright 2016 Igor Maznitsa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.igormaznitsa.sciareto.ui.editors;

import java.io.File;
import javax.swing.JScrollPane;
import com.igormaznitsa.sciareto.ui.DialogProviderManager;
import com.igormaznitsa.sciareto.ui.tabs.TabProvider;

public abstract class AbstractScrollPane extends JScrollPane implements TabProvider {

  private static final long serialVersionUID = -6865229547826910048L;
  
  public AbstractScrollPane(){
    super();
  }

  @Override
  public boolean saveDocumentAs() {
    final File file = this.getTabTitle().getAssociatedFile();
    final File fileToSave = DialogProviderManager.getInstance().getDialogProvider().msgSaveFileDialog("save-as", "Save as", file, true, getFileFilter(), "Save");
    if (fileToSave!=null){
      this.getTabTitle().setAssociatedFile(fileToSave);
      this.getTabTitle().setChanged(true);
      this.saveDocument();
      return true;
    }
    return false;
  }

}
